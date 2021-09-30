package com.example.retrofitwithmvvm.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class VolumesResponse {
    @SerializedName("kind")
    @Expose
    private val kind: String? = null

    @SerializedName("items")
    @Expose
    var items: List<Volume>? = null

    @SerializedName("totalItems")
    @Expose
    var totalItems = 0

    fun getKind(): String? {
        return kind
    }

    @JvmName("getItems1")
    fun getItems(): List<Volume>? {
        return items
    }

    @JvmName("getTotalItems1")
    fun getTotalItems(): Int {
        return totalItems
    }
}