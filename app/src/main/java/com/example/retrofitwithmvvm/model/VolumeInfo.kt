package com.example.retrofitwithmvvm.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class VolumeInfo {
    @SerializedName("title")
    @Expose
    private val title: String? = null

    @SerializedName("authors")
    @Expose
    private val authors: List<String?>? = null

    @SerializedName("publisher")
    @Expose
    private val publisher: String? = null

    @SerializedName("publishedDate")
    @Expose
    private val publishedDate: String? = null

    @SerializedName("description")
    @Expose
    private val description: String? = null

    @SerializedName("pageCount")
    @Expose
    private val pageCount = 0

    @SerializedName("printType")
    @Expose
    private val printType: String? = null

    @SerializedName("imageLinks")
    @Expose
    private val imageLinks: VolumeImageLinks? = null

    fun getTitle(): String? {
        return title
    }

    fun getAuthors(): List<String?>? {
        return authors
    }

    fun getPublisher(): String? {
        return publisher
    }

    fun getPublishedDate(): String? {
        return publishedDate
    }

    fun getDescription(): String? {
        return description
    }

    fun getPageCount(): Int {
        return pageCount
    }

    fun getPrintType(): String? {
        return printType
    }

    fun getImageLinks(): VolumeImageLinks? {
        return imageLinks
    }
}