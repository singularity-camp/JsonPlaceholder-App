package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.ToDosRepository

class GetUserToDosUseCase(private val toDosRepository: ToDosRepository) {
    suspend operator fun invoke(userId : Int) : List<ToDo> {
        return toDosRepository.getUserToDos(userId)
    }
}