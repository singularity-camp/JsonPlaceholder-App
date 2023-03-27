package kz.tutorial.jsonplaceholdertypicode.data

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.Post
import kz.tutorial.jsonplaceholdertypicode.domain.PostsRepository

class PostsRepositoryImpl(private val mainApi: MainApi) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return mainApi.getPosts()
    }

    override suspend fun getPostDetails(id: Int): Post {
        return mainApi.getPostDetailsById(id = id.toString())
    }

    override suspend fun getComments(postId: Int): List<Comment> {
        return mainApi.getComments(postId = postId.toString())
    }

}