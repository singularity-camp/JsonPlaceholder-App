package kz.tutorial.jsonplaceholdertypicode.domain

class GetCurrPostUseCase(private val postsRepository : PostsRepository) {
    suspend operator fun invoke(id : Int): Post {
        return postsRepository.getCurrPost(id = id)
    }
}