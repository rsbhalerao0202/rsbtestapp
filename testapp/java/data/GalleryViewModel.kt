package com.example.fourrwallsrsbtestapp.data.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fourrwallsrsbtestapp.coroutines.Coroutines
import com.example.fourrwallsrsbtestapp.data.GalleryData
import com.example.fourrwallsrsbtestapp.data.repositories.GalleryRepository
import kotlinx.coroutines.Job

class GalleryViewModel( private val repository: GalleryRepository): ViewModel() {
    private val _photos = MutableLiveData<List<GalleryData>>()

    private lateinit var job: Job

    val photos : MutableLiveData<List<GalleryData>>
        get() = _photos

    fun getPhotos(){
        job = Coroutines.ioMain(
            {repository.getPhotos()},
            {_photos.value = it}
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}