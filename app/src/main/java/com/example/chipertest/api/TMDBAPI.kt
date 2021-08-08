package com.example.chipertest.api

import com.example.chipertest.models.RequestToken
import retrofit2.Call
import retrofit2.http.POST

interface TMDBAPI {
    @POST("auth/request_token")
    fun reqAccessToken(): Call<RequestToken>

}