package com.example.retrofitwithmvvm

import org.koin.dsl.module



class MainRepository(private val retrofitService: RetrofitService) {

    suspend fun getAllBooks(key:String, author:String, apiKey:String) = retrofitService.getAllBooks(key,author,apiKey)
}