package com.example.retrofit_2.model.login

data class LoginBody(
    val deviceId: String,
    val hashcentral: String,
    val password: String,
    val pushKey: String,
    val username: String
)