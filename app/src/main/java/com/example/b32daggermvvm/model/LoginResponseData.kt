package com.example.b32daggermvvm.model

data class LoginResponseData(
    val token: String,
    val user: User
)
data class User(
    val email: String,
    val name: String,
    val password: String,
    val type: String
)