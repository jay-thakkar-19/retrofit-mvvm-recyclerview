package com.example.retrofitmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvm.databinding.UserListBinding
import com.example.retrofitmvvm.model.User

class UserAdapter(private val list:List<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding=UserListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.view.tvId.text=list[position].id.toString()
        holder.view.tvLogin.text=list[position].login
        holder.view.tvRepo.text=list[position].repos_url
        holder.view.tvAdmin.text=list[position].site_admin.toString()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class UserViewHolder(val view:UserListBinding):RecyclerView.ViewHolder(view.root)

}