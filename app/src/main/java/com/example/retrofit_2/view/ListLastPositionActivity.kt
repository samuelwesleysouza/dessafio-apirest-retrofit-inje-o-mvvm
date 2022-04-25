package com.example.retrofit_2.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_2.api.Endpoints
import com.example.retrofit_2.model.last_position.LastPositionResponse
import com.example.retrofit_2.model.last_position.LastPositionResponseItem
import com.example.retrofit_2.utils.NetworksUtil
import retrofit2.Call
import retrofit2.Response

/**
 * para vc logar no app, vc precisa usar as credênciais
 * Login: vaga.android@central.com
 * Senha: Mobile@123
 * */

const val BEARER = "Bearer"
const val BASE_URL_LAST_POSITION = "http://core.systemsatx.com.br/v1/"

class ListLastPositionActivity: AppCompatActivity() {
    var accessToken: String?= null


    var listLastPosition = arrayListOf<LastPositionResponseItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.let {
            accessToken = it.getString(ACCESS_TOKEN)
        }
        callApiLastPosition()
    }

    private fun callApiLastPosition() {
        val retClient = NetworksUtil.getRetrofitInstance(BASE_URL_LAST_POSITION)
        val endpoints = retClient.create(Endpoints::class.java)
        val token = BEARER.plus(" ").plus(accessToken)
        endpoints.getLastPosition(token).enqueue(object : retrofit2.Callback<LastPositionResponse>{
            override fun onResponse(
                call: Call<LastPositionResponse>,
                response: Response<LastPositionResponse>
            ) {
                 response.body()?.let { list->
                     listLastPosition = list
                     Log.i("listLastPosition", "$listLastPosition")
                }
            }



            override fun onFailure(call: Call<LastPositionResponse>, t: Throwable) {
                Toast.makeText(baseContext,"Error no login", Toast.LENGTH_LONG).show()
            }

        })

    }
}