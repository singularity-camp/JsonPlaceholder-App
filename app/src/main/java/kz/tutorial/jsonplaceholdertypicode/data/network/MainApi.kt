package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.data.models.RemoteAlbum
import kz.tutorial.jsonplaceholdertypicode.domain.models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPostDetailsById(@Path("id") id: Int): Post

    @GET("comments")
    suspend fun getComments(@Query("postId") postId: Int): List<Comment>

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User

    @GET("albums")
    suspend fun getAlbums(): List<RemoteAlbum>

    @GET("photos")
    suspend fun getAlbumPhotos(@Query("albumId") albumId: Int): List<Photo>

    @GET("albums/{id}")
    suspend fun getRemoteAlbumById(@Path("id") albumId: Int): RemoteAlbum

    @GET("photos")
    suspend fun getAllPhotos(): List<Photo>

    @GET("todos")
    suspend fun getTodo(@Query("userId") userId: Int): List<ToDo>
}