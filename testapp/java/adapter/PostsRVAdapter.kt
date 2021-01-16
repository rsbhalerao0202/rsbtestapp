package com.example.fourrwallsrsbtestapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fourrwallsrsbtestapp.R
import com.example.fourrwallsrsbtestapp.callbacks.PostsRVCallback
import com.example.fourrwallsrsbtestapp.data.PostsData
import com.example.fourrwallsrsbtestapp.databinding.PostsRvBinding

class PostsRVAdapter(
    private val posts: List<PostsData>,
    private val callback : PostsRVCallback
): RecyclerView.Adapter<PostsRVAdapter.PostsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostsViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.posts_rv, parent, false)
        )

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.postsRvBinding.post = posts[position]

        holder.postsRvBinding.root.setOnClickListener {
            callback.rvItemClickCallback(holder.postsRvBinding.root, posts[position])
        }

    }

    override fun getItemCount() = posts.size

    inner class PostsViewHolder(
        val postsRvBinding: PostsRvBinding
    ): RecyclerView.ViewHolder(postsRvBinding.root){

    }

}