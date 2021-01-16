package com.example.fourrwallsrsbtestapp.network

import com.example.fourrwallsrsbtestapp.data.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PostApi {

    @GET("posts")
    suspend fun getPosts():Response<List<PostsData>>

    @GET("posts")
    suspend fun getPostdetail(@Query("id") id:String?):Response<List<PostDetailsData>>

    @GET("comments")
    suspend fun getPostComments(@Query("postId") postid:String?):Response<List<PostCommentsData>>

    @GET("photos")
    suspend fun getPhotos():Response<List<GalleryData>>

    @GET("users")
    suspend fun getUsers():Response<List<UsersData>>


    companion object{
    operator fun invoke():PostApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
            .create(PostApi::class.java)
    }
}
}