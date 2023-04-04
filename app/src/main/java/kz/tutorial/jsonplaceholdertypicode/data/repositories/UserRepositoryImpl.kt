package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UserRepository

class UserRepositoryImpl(private val mainApi: MainApi) : UserRepository {
    override suspend fun getUser(userId: Int): User {
        return mainApi.getUser(userId)
    }

    override suspend fun getUsers() : List<User> {
        return mainApi.getUsers()
    }
}