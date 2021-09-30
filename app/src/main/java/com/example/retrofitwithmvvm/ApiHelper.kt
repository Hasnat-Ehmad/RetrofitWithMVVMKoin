package com.example.retrofitwithmvvm

import com.example.retrofitwithmvvm.model.VolumesResponse



interface ApiHelper {

    suspend fun getBookList(key:String,author:String,apiKey:String): VolumesResponse

}