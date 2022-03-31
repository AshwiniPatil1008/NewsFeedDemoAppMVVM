package com.example.newfeeddemoapp.Models

import com.google.gson.annotations.SerializedName

data class TotalNews(
    @SerializedName("totalResults") var totalNewsCount: Int,

    @SerializedName("articles") var newsList: List<News>? = null,

    @SerializedName("status") var status: String,

  )

