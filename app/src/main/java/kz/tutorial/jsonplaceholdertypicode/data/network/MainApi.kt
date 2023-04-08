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
    suspend fun getPost(@Path("id") id: Int): Post

    //Здесь можно в целом разделить и создать несколько API файлов,
    //но поскольку апишка у нас небольшая, мы можем всё писать здесь
    @GET("comments")
    suspend fun getPostComments(@Query("postId") postId: Int): List<Comment>

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User

    @GET("albums")
    suspend fun getAlbums(): List<RemoteAlbum>

    @GET("photos")
    suspend fun getAlbumPhotos(@Query("albumId") albumId: Int): List<Photo>

    @GET("photos")
    suspend fun getAllPhotos(): List<Photo>

    @GET("todos")
    suspend fun getUserToDos(@Query("userId") userId: Int) : List<ToDo>

}