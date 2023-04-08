package kz.tutorial.jsonplaceholdertypicode.domain.repositories

import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo

interface ToDosRepository {
    suspend fun getUserToDos(userId : Int) : List<ToDo>
}