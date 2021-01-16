package com.example.fourrwallsrsbtestapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fourrwallsrsbtestapp.R
import com.example.fourrwallsrsbtestapp.callbacks.UsersRVCallback
import com.example.fourrwallsrsbtestapp.data.UsersData
import com.example.fourrwallsrsbtestapp.databinding.UsersRvBinding

class UsersRVAdapter(
    private val users: List<UsersData>,
    private val callback: UsersRVCallback
): RecyclerView.Adapter<UsersRVAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UsersViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.users_rv, parent, false)
    )

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.usersRvBinding.users = users[position]
    }

    override fun getItemCount() = users.size

    inner class UsersViewHolder(
        val usersRvBinding: UsersRvBinding
    ): RecyclerView.ViewHolder(usersRvBinding.root){

    }

}