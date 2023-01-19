package kz.tutorial.jsonplaceholdertypicode

import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): List<Post>

}