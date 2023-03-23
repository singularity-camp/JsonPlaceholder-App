package kz.tutorial.jsonplaceholdertypicode.data

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UsersRepository
import kz.tutorial.jsonplaceholdertypicode.domain.models.User

class UsersRepositoryImpl(private val mainApi: MainApi) : UsersRepository {
    override suspend fun getUser(id: Int): User {
        return mainApi.getUser(id)
    }
}