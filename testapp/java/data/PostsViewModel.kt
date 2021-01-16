package com.example.fourrwallsrsbtestapp.data.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fourrwallsrsbtestapp.coroutines.Coroutines
import com.example.fourrwallsrsbtestapp.data.PostsData
import com.example.fourrwallsrsbtestapp.data.repositories.PostRepository
import kotlinx.coroutines.Job

class PostsViewModel( private val repository: PostRepository): ViewModel() {
    private val _posts = MutableLiveData<List<PostsData>>()

    private lateinit var job: Job

    val posts : MutableLiveData<List<PostsData>>
            get() = _posts

     fun getPosts(){
         job = Coroutines.ioMain(
             {repository.getPosts()},
             {_posts.value = it}
         )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}