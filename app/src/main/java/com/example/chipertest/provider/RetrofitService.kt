package com.example.chipertest.provider

import com.example.chipertest.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {
    private val BASE_URL = BuildConfig.BASE_URL
    val instance = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(TMDBClient().getClient())
        .build()
}