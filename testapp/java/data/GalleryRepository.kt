package com.example.fourrwallsrsbtestapp.data.repositories

import com.example.fourrwallsrsbtestapp.network.ApiRequest
import com.example.fourrwallsrsbtestapp.network.PostApi

class GalleryRepository(
    private val api: PostApi
): ApiRequest() {
    suspend fun getPhotos() = apiRequest { api.getPhotos() }
}