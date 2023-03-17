package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.domain.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface MainApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostDetailsById(@Path("id") id : String) : Post

    @GET("posts/{postId}/comments")
    suspend fun getCommentsToPost(@Path("postId") postId : String) : List<Comment>

}