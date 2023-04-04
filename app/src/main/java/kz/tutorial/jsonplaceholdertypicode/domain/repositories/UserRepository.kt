package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.User

interface UserRepository {
    suspend fun getUser(userId: Int): User

    suspend fun getUsers() : List<User>
}