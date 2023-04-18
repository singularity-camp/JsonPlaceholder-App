package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository

class SubmitPostUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(userId: Long, title: String, body: String): Post {
        return postsRepository.submitPost(userId = userId, title = title, body = body)
    }
}