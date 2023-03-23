package kz.tutorial.jsonplaceholdertypicode.domain

interface PostsRepository {
    suspend fun getPosts(): List<Post>
    suspend fun getPost(id: Int): Post
}