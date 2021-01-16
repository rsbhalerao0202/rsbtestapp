package com.example.fourrwallsrsbtestapp.data.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fourrwallsrsbtestapp.data.repositories.GalleryRepository
import com.example.fourrwallsrsbtestapp.data.repositories.PostRepository

class GalleryViewModelFactory(
    private val repository: GalleryRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GalleryViewModel(repository) as T
    }
}