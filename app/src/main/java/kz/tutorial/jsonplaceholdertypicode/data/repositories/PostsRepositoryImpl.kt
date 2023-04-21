package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.constants.CURRENT_USER_ID
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

    override suspend fun submitPost(title: String, body: String): Post {
        val newPost = PostRequest(userId = CURRENT_USER_ID.toLong(), title = title, body = body)
        return mainApi.submitPost(newPost)
    }

}