package com.example.fourrwallsrsbtestapp.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fourrwallsrsbtestapp.data.repositories.PostRepository

class PostsViewModelFactory(
    private val repository: PostRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(repository) as T
    }
}