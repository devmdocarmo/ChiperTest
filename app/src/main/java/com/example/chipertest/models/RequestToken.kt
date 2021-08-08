package com.example.chipertest.models


import com.google.gson.annotations.SerializedName

data class RequestToken(
    @SerializedName("request_token")
    val requestToken: String,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("status_message")
    val statusMessage: String,
    @SerializedName("success")
    val success: Boolean
)