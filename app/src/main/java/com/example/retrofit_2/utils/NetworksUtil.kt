package com.example.retrofit_2.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworksUtil {
    companion object{
        fun getRetrofitInstance(baseUrl: String): Retrofit{
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun getLoggingInterceptor() = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)

        private fun getHttpClient() = OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .build()

    }
}
