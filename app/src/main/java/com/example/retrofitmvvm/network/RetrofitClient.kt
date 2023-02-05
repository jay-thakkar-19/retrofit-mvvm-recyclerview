package com.example.retrofitmvvm.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val BaseUrl="https://api.github.com/"

    fun getRestAdapter(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}