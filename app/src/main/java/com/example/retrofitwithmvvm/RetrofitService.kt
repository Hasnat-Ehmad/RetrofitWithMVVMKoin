package com.example.retrofitwithmvvm

import com.example.retrofitwithmvvm.model.VolumesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("/books/v1/volumes")
    suspend fun getAllBooks(
        @Query("q") query: String?,
        @Query("inauthor") author: String?,
        @Query("key") apiKey: String?
    ) : VolumesResponse

}