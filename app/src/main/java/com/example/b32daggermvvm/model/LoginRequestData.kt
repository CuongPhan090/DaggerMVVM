package com.example.b32daggermvvm.model

import com.google.gson.annotations.SerializedName

data class LoginRequestData(

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String
)
