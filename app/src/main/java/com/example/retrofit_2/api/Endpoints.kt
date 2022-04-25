package com.example.retrofit_2.api

import com.example.retrofit_2.model.last_position.LastPositionResponse
import com.example.retrofit_2.model.login.LoginBody
import com.example.retrofit_2.model.login.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface Endpoints {
    @POST("account/loginAndroid")
    fun getLogin( @Body loginBody: LoginBody): Call<LoginResponse>

    @GET("position/getLastPositionApp")
    fun getLastPosition(
        @Header("Authorization") authorization: String): Call<LastPositionResponse>
}