package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.data.models.AlbumResponse
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import retrofit2.http.*

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
    suspend fun getAlbums(): List<AlbumResponse>

    @GET("photos")
    suspend fun getAlbumPhotos(@Query("albumId") albumId: Int): List<Photo>

    @GET("photos")
    suspend fun getAllPhotos(): List<Photo>

    @FormUrlEncoded
    @POST("posts")
    suspend fun submitPost(
        @Field("title") title: String,
        @Field("body") body: String,
        @Field("userId") userId: Long
    ): Post


}