package kz.tutorial.jsonplaceholdertypicode

class PostsRepositoryImpl(private val mainApi: MainApi) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return mainApi.getPosts()
    }

}