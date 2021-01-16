package com.example.fourrwallsrsbtestapp.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fourrwallsrsbtestapp.data.repositories.PostCommentsRepository

@Suppress("UNCHECKED_CAST")
class PostCommentsViewModelFactory(
    private val repository: PostCommentsRepository
): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostCommentsViewModel(repository) as T
    }
}