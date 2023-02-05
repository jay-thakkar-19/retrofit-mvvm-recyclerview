package com.example.retrofitmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import com.example.retrofitmvvm.model.User
import com.example.retrofitmvvm.repository.MainRepository

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val userList=MutableLiveData<List<User>>()
    val userError=MutableLiveData<String>()

    fun getUsers(){
        val response=repository.getUsers()
        response.enqueue(object : retrofit2.Callback<List<User>>{
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                userList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                userError.postValue(t.localizedMessage)
            }
        })
    }

}