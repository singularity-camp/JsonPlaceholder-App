package kz.tutorial.jsonplaceholdertypicode

import retrofit2.http.GET

interface MainApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

}