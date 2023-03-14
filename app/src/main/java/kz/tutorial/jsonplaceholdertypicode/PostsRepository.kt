package kz.tutorial.jsonplaceholdertypicode

interface PostsRepository {
    suspend fun getPosts(): List<Post>
}