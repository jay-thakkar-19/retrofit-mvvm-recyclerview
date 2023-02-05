package com.example.retrofitmvvm.network

import com.example.retrofitmvvm.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<List<User>>

}