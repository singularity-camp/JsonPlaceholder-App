package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.models.UserShort

interface UserRepository {
    suspend fun getUser(userId: Int): User
    suspend fun getUsersShort(): List<UserShort>
}