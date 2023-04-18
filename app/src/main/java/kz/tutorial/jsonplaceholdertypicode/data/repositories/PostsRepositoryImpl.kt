package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.models.PostRequest
import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository

class PostsRepositoryImpl(private val mainApi: MainApi) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return mainApi.getPosts()
    }

    override suspend fun getPost(id: Int): Post {
        return mainApi.getPost(id)
    }

    override suspend fun submitPost(userId: Long, title: String, body: String): Post {
        val postRequest = PostRequest(userId = userId, title = title, body = body)

        return mainApi.submitPost(userId = userId, title = title, body = body)
    }


}