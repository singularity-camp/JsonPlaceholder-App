package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post

class GetPostDetailsUseCase(private val postsRepository : PostsRepository) {
    suspend operator fun invoke(id : Int): Post {
        return postsRepository.getPostDetails(id = id)
    }
}