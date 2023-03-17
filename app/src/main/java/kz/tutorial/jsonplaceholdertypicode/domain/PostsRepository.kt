package kz.tutorial.jsonplaceholdertypicode.domain

import kz.tutorial.jsonplaceholdertypicode.domain.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getCurrPost(id : Int) : Post
    suspend fun getCommentsToPost(postId : Int) : List<Comment>
}