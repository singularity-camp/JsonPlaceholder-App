package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository

class GetPostsUseCase(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(): List<Post> {
        return postsRepository.getPosts()
    }
}