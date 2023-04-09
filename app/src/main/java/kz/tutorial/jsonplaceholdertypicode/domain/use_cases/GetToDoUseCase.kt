package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.ToDoRepository

class GetToDoUseCase(private val toDoRepository: ToDoRepository) {
    suspend operator fun invoke(userId: Int): List<ToDo> {
        return toDoRepository.getTodo(userId)
    }
}