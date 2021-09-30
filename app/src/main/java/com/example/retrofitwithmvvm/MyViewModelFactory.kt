package com.example.retrofitwithmvvm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory constructor(private val apiHelperImpl: ApiHelperImpl): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.apiHelperImpl) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}