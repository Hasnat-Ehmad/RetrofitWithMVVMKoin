package com.example.retrofitwithmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitwithmvvm.model.VolumesResponse
import com.example.retrofitwithmvvm.util.Resource
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { ApiHelperImpl(get()) }
    viewModel { MainViewModel(get()) }
}

class MainViewModel(private val apiHelperImpl: ApiHelperImpl)  : ViewModel() {

    private val bookList = MutableLiveData<Resource<VolumesResponse>>()

    fun fetchBookList(key:String,author:String,apiKey:String){
        viewModelScope.launch {
            bookList.postValue(Resource.loading(null))
            try {
                val bookFromApi = apiHelperImpl.getBookList(key,author,apiKey)
                bookList.postValue(Resource.success(bookFromApi))
            } catch (e: Exception) {
                bookList.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getBookList(): MutableLiveData<Resource<VolumesResponse>>{
        return bookList
    }
}