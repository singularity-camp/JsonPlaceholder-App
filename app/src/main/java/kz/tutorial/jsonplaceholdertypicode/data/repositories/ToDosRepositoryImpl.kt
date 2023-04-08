package kz.tutorial.jsonplaceholdertypicode.data.repositories

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.ToDosRepository

class ToDosRepositoryImpl(private val mainApi: MainApi) : ToDosRepository {
    override suspend fun getUserToDos(userId : Int): List<ToDo> {
        return mainApi.getUserToDos(userId)
    }
}