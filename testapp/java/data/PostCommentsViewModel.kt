package com.example.fourrwallsrsbtestapp.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fourrwallsrsbtestapp.coroutines.Coroutines
import com.example.fourrwallsrsbtestapp.data.PostCommentsData
import com.example.fourrwallsrsbtestapp.data.repositories.PostCommentsRepository
import kotlinx.coroutines.Job

class PostCommentsViewModel(
    private val repository: PostCommentsRepository
): ViewModel() {
    private lateinit var job: Job
    private val _comments = MutableLiveData<List<PostCommentsData>>()
    val comments: LiveData<List<PostCommentsData>>
    get() = _comments

    fun getPostComments(ids: String) {
        job = Coroutines.ioMain(
            {repository.getPostComments(ids)},
            { _comments.value = it }
        )

    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}