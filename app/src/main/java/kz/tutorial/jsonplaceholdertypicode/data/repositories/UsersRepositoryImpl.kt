package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UsersRepository

class UsersRepositoryImpl(private val mainApi: MainApi) : UsersRepository {
    override suspend fun getUsers(): List<User> {
        return mainApi.getUsers()
    }
}