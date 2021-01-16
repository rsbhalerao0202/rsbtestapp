package com.example.fourrwallsrsbtestapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fourrwallsrsbtestapp.R
import com.example.fourrwallsrsbtestapp.data.PostCommentsData
import com.example.fourrwallsrsbtestapp.databinding.CommentsRvBinding

class PostCommentAdapter(
    private val comments: List<PostCommentsData>
) : RecyclerView.Adapter<PostCommentAdapter.CommentsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder =
        CommentsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.comments_rv,
                parent, false
            )
        )

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.commentsRvBinding.comments = comments[position]
    }

    override fun getItemCount() = comments.size


    inner class CommentsViewHolder(
        val commentsRvBinding: CommentsRvBinding
    ) : RecyclerView.ViewHolder(commentsRvBinding.root) {

    }


}