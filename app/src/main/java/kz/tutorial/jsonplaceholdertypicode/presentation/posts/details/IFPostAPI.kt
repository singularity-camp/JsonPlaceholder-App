package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import kz.tutorial.jsonplaceholdertypicode.domain.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface IFPostAPI {
    @GET("posts/{id}")
    suspend fun getPostsOne(@Path("id") id: Int) : Post
}