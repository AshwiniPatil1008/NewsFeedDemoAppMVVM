package com.example.newfeeddemoapp.networkServices

import com.example.newfeeddemoapp.Models.TotalNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("v2/top-headlines")
    fun getNewsList(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ): Call<TotalNews>


}