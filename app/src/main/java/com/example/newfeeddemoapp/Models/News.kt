package com.example.newfeeddemoapp.Models

import com.google.gson.annotations.SerializedName

import java.util.*

data class News(

    @SerializedName("title") var newsTitle: String,

    @SerializedName("description") var newsDescription: String,

    @SerializedName("url") var newsUrl: String,

    @SerializedName("urlToImage") var newsImage: String,

    @SerializedName("publishedAt") var newsPublishedDate: Date
)
