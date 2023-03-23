package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.User

interface UsersRepository {
    suspend fun getUser(id: Int) : User
}