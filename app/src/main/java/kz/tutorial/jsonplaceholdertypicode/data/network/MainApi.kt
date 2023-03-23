package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.domain.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.Post
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostWithID(@Path("id") id: Int): Post

    @GET("comments")
    suspend fun getCommentsList(@Query("postId") postId: Int): List<Comment>

}