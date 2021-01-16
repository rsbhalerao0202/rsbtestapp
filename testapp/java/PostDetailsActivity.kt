package com.example.fourrwallsrsbtestapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fourrwallsrsbtestapp.adapters.PostCommentAdapter
import com.example.fourrwallsrsbtestapp.data.model.PostCommentsViewModel
import com.example.fourrwallsrsbtestapp.data.model.PostCommentsViewModelFactory
import com.example.fourrwallsrsbtestapp.data.repositories.PostCommentsRepository
import com.example.fourrwallsrsbtestapp.data.repositories.PostDetailRepository
import com.example.fourrwallsrsbtestapp.databinding.ActivityPostDetailsBinding
import com.example.fourrwallsrsbtestapp.network.PostApi
import kotlinx.android.synthetic.main.activity_post_details.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PostDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityPostDetailsBinding

    private lateinit var postCommentsViewModel: PostCommentsViewModel
    private lateinit var factory: PostCommentsViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_details)

        setSupportActionBar(toolbar2)
        toolbar2.setTitleTextColor(Color.WHITE);
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);


        supportActionBar!!.setDisplayShowTitleEnabled(false)


        val intent = intent

        val id = intent.getStringExtra("postid")
//        Toast.makeText(this@PostDetailsActivity, "" + id, Toast.LENGTH_LONG).show()

        val repository = PostDetailRepository(PostApi())
        GlobalScope.launch(Dispatchers.Main) {
            val details = repository.getPostDetail(id)
            Log.v("detail", details.toString() + " ")
            binding.tvTitlePda.text = details[0].title
            binding.tvDetailsPda.text = details[0].body

//            Toast.makeText(this@PostDetailsActivity, "" + details, Toast.LENGTH_LONG).show()

            val api = PostApi()
            val repository = PostCommentsRepository(api)
            factory = PostCommentsViewModelFactory(repository)
            postCommentsViewModel = ViewModelProviders.of(this@PostDetailsActivity, factory).get(
                PostCommentsViewModel::class.java
            )
            postCommentsViewModel.getPostComments("" + details[0].userId)
            postCommentsViewModel.comments.observe(this@PostDetailsActivity, Observer { comments ->
                rv_comments.also {
                    it.layoutManager = LinearLayoutManager(this@PostDetailsActivity)
                    it.setHasFixedSize(true)
                    it.adapter = PostCommentAdapter(comments)
                }
            })

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed();
        return true;
    }
}