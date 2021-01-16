package com.example.fourrwallsrsbtestapp.data.repositories

import com.example.fourrwallsrsbtestapp.network.ApiRequest
import com.example.fourrwallsrsbtestapp.network.PostApi

class UserRepository(    private val api: PostApi
): ApiRequest() {
    suspend fun getUsers() = apiRequest { api.getUsers() }
}