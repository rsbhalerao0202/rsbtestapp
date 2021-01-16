package com.example.fourrwallsrsbtestapp.data.repositories

import com.example.fourrwallsrsbtestapp.network.ApiRequest
import com.example.fourrwallsrsbtestapp.network.PostApi

class PostRepository(
    private val api: PostApi
): ApiRequest() {
    suspend fun getPosts() = apiRequest { api.getPosts() }
}