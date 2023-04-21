package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository

class GetSubmitPostUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(title: String, body: String): Post {
        return postsRepository.submitPost(title = title, body = body)
    }
}