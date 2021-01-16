package com.example.fourrwallsrsbtestapp.data.repositories

import com.example.fourrwallsrsbtestapp.network.ApiRequest
import com.example.fourrwallsrsbtestapp.network.PostApi

class PostDetailRepository( private val api: PostApi
): ApiRequest() {
    suspend fun getPostDetail(id: String?) = apiRequest { api.getPostdetail(id) }
}