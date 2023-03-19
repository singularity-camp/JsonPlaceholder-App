package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository

class GetPostByIdUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(id: Int): Post {
        return postsRepository.getPost(id)
    }
}