package com.example.retrofitwithmvvm



class ApiHelperImpl(private val apiService: RetrofitService) : ApiHelper {

    override suspend fun getBookList(key:String,author:String,apiKey:String) = apiService.getAllBooks(key,author,apiKey)

}