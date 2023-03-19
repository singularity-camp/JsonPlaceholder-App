package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>

    suspend fun getPost(id: Int): Post
}