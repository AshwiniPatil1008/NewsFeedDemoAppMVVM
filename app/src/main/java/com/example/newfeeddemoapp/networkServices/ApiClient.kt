package com.example.newfeeddemoapp.networkServices

import com.example.newfeeddemoapp.Util.Utils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val client = OkHttpClient.Builder().build()
    private lateinit var retrofit: Retrofit
    fun getClient(): Retrofit {
            retrofit = Retrofit.Builder()
                .baseUrl(Utils.BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

        return retrofit
    }
}