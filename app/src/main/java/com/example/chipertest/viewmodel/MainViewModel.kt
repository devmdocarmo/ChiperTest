package com.example.chipertest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chipertest.models.RequestToken

class MainViewModel : ViewModel() {
    private val reqToken: MutableLiveData<List<RequestToken>> by lazy {
        MutableLiveData<List<RequestToken>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<RequestToken>> {
        return reqToken
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }
}