package kz.tutorial.jsonplaceholdertypicode.domain.usecases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository

class GetPostDetailsUseCase(private val postDetailsRepository: PostsRepository) {
    suspend operator fun invoke(id: Int): Post {
        return postDetailsRepository.getPost(id)
    }
}