package com.example.retrofitwithmvvm.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class VolumeImageLinks {
    @SerializedName("smallThumbnail")
    @Expose
    private val smallThumbnail: String? = null

    @SerializedName("thumbnail")
    @Expose
    private val thumbnail: String? = null

    fun getSmallThumbnail(): String? {
        return smallThumbnail
    }

    fun getThumbnail(): String? {
        return thumbnail
    }
}