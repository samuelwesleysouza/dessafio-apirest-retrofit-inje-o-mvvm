package com.example.retrofit_2.model.login

data class LoginResponse(
    val accessToken: String,
    val expiresIn: String,
    val refreshToken: String
)