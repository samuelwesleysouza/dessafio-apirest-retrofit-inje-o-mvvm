package com.example.retrofit_2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retrofit_2.api.Endpoints
import com.example.retrofit_2.databinding.ActivityLoginBinding
import com.example.retrofit_2.model.login.LoginBody
import com.example.retrofit_2.model.login.LoginResponse
import com.example.retrofit_2.utils.NetworksUtil
import retrofit2.Call
import retrofit2.Response

const val DEVICE_ID = "12345678910"
const val PUSH_KEY = "12345678910"
const val HASH_CENTRAL = ""
const val ACCESS_TOKEN = "ACCESS_TOKEN"
const val BASE_URL_LOGIN = "https://login.systemsatx.com.br/v1/"

/**
 * para vc logar no app, vc precisa usar as credênciais
 * Login: vaga.android@central.com
 * Senha: Mobile@123
 * */

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListener()


    }

    private fun setListener() {
        binding.apply {
            btnLogin.setOnClickListener {
                callApiLogin()
            }
        }
    }

    private fun callApiLogin() {
        val retClient = NetworksUtil.getRetrofitInstance(BASE_URL_LOGIN)
        val endpoints = retClient.create(Endpoints::class.java)
        val loginBody = LoginBody(DEVICE_ID, HASH_CENTRAL, binding.etSenha.text.toString(), PUSH_KEY, binding.etLogin.text.toString())
        Log.i("login", "$loginBody")

        endpoints.getLogin(loginBody).enqueue(object : retrofit2.Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                response.let { res->
                    when (res.code()) {
                        200,202, 204 -> {
                            val intent = Intent(this@LoginActivity, ListLastPositionActivity::class.java).apply {
                                putExtra(ACCESS_TOKEN, response.body()?.accessToken)
                            }
                            startActivity(intent)
                        }
                        else -> {
                            Toast.makeText(baseContext,"Error no login: ${res.code()}", Toast.LENGTH_LONG).show()
                        }
                    }
                }

            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Toast.makeText(baseContext,"Error no login", Toast.LENGTH_LONG).show()
            }

        })

    }
}

