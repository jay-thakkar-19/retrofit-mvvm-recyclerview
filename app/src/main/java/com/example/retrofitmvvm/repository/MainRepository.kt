package com.example.retrofitmvvm.repository

import com.example.retrofitmvvm.network.ApiService

class MainRepository constructor(private val apiService: ApiService) {
    fun getUsers()=apiService.getUsers()
}