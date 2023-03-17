package kz.tutorial.jsonplaceholdertypicode.presentation.posts.comments

import retrofit2.http.GET
import retrofit2.http.Query

interface IFCommentAPI {
    @GET("comments")
    suspend fun getCommentsList(@Query("postId") postId: Int,) : List<Comment>
}