package com.example.fourrwallsrsbtestapp.data.repositories

import com.example.fourrwallsrsbtestapp.network.ApiRequest
import com.example.fourrwallsrsbtestapp.network.PostApi

class PostCommentsRepository(
    private val api : PostApi
): ApiRequest() {
    suspend fun getPostComments(id: String?) = apiRequest { api.getPostComments(id) }
}