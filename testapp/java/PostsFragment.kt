package com.example.fourrwallsrsbtestapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fourrwallsrsbtestapp.adapters.PostsRVAdapter
import com.example.fourrwallsrsbtestapp.callbacks.PostsRVCallback
import com.example.fourrwallsrsbtestapp.data.PostsData
import com.example.fourrwallsrsbtestapp.data.model.PostsViewModel
import com.example.fourrwallsrsbtestapp.data.model.PostsViewModelFactory
import com.example.fourrwallsrsbtestapp.network.PostApi
import com.example.fourrwallsrsbtestapp.data.repositories.PostRepository
import kotlinx.android.synthetic.main.fragment_posts.*

class PostsFragment : Fragment(), PostsRVCallback {

    private lateinit var viewModel: PostsViewModel
    private lateinit var factory: PostsViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = PostApi()
        val repository = PostRepository(api)
        factory = PostsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(PostsViewModel::class.java)
        viewModel.getPosts()
        viewModel.posts.observe(viewLifecycleOwner, Observer { posts ->
            rv_posts.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = PostsRVAdapter(posts, this)
            }

        })
    }

    override fun rvItemClickCallback(view: View, posts: PostsData) {

        startActivity(Intent(requireContext(), PostDetailsActivity::class.java).putExtra("postid", ""+posts.id))

//        Toast.makeText(requireContext(), ""+posts.id, Toast.LENGTH_LONG).show()
    }

}