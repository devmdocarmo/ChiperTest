package com.example.chipertest.repository

import com.example.chipertest.provider.RetrofitService

class MoviesRepository {

    val retrofit = RetrofitService()

    fun getToken(){
        retrofit
    }
}