package com.example.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitmvvm.adapter.UserAdapter
import com.example.retrofitmvvm.databinding.ActivityMainBinding
import com.example.retrofitmvvm.factory.MainFactory
import com.example.retrofitmvvm.network.ApiService
import com.example.retrofitmvvm.network.RetrofitClient
import com.example.retrofitmvvm.repository.MainRepository
import com.example.retrofitmvvm.viewmodel.MainViewModel
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    lateinit var mainViewModel: MainViewModel
    private var eRetrofit : Retrofit? =null
    private var apiService: ApiService? = null
    private val apiClient = RetrofitClient()

    lateinit var userAdapter:UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        eRetrofit=apiClient.getRestAdapter()
        apiService=eRetrofit!!.create(ApiService::class.java)

        mainViewModel= ViewModelProvider(this, MainFactory(MainRepository(apiService!!))).get(MainViewModel::class.java)
        mainViewModel.userList.observe(this){
            userAdapter = UserAdapter(it)
            binding.rv.layoutManager=LinearLayoutManager(this)
            binding.rv.adapter=userAdapter
        }
        mainViewModel.userError.observe(this){
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
        }
        mainViewModel.getUsers()

    }
}