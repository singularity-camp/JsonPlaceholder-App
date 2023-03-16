package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import kz.tutorial.jsonplaceholdertypicode.domain.Post
import retrofit2.http.GET

interface IFPostAPI {
    @GET("posts/1")
    suspend fun getPostsOne() : Post
}