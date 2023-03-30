package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostDetailsById(@Path("id") id: String): Post

    @GET("comments")
    suspend fun getComments(@Query("postId") postId: Int): List<Comment>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User

}