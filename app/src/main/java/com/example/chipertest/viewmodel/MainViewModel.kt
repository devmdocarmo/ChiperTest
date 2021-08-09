package com.example.chipertest.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chipertest.BuildConfig
import com.example.chipertest.api.TMDBAPI
import com.example.chipertest.models.ListMovies
import com.example.chipertest.provider.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainViewModel : ViewModel() {
    private val retrofit = RetrofitService().instance.create<TMDBAPI>()

    private val reqToken: MutableLiveData<ListMovies> by lazy {
        MutableLiveData<ListMovies>().also {
            loadAListofMovies()
        }
    }

    fun getMovies(): LiveData<ListMovies> {
        return reqToken
    }

    private fun loadAListofMovies() {
        // Do an asynchronous operation to fetch users.
        retrofit.getListofMovies(10, page = 1, apiKey = BuildConfig.ACCESS_TOKEN)
            .enqueue(object : Callback<ListMovies> {
                override fun onResponse(call: Call<ListMovies>, response: Response<ListMovies>) {
                    if(response.isSuccessful) {
                        Log.d("RESPONSE", response.body().toString())
                        reqToken.value = response.body()
                    }else{
                        Log.e("RESPONSE", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<ListMovies>, t: Throwable) {
                    Log.e("RESPONSE", t.message.toString())
                }

            }
        )
    }
}