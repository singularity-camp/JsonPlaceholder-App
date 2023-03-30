package kz.tutorial.jsonplaceholdertypicode.presentation.users.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetToDoListUseCase

class ToDoViewModel(private val userId: Int, private val getToDoListUseCase: GetToDoListUseCase) :
    ViewModel() {
    private val _toDoList = MutableLiveData<List<ToDo>>()
    val toDoList: LiveData<List<ToDo>> = _toDoList

    init {
        getToDoList()
    }

    private fun getToDoList() {
        viewModelScope.launch {
            val todo = getToDoListUseCase(userId)
            _toDoList.postValue(todo)
        }
    }
}