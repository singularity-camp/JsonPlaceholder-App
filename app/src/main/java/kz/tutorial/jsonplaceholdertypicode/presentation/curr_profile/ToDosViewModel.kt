package kz.tutorial.jsonplaceholdertypicode.presentation.curr_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.ToDo
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserToDosUseCase

class ToDosViewModel(private val userId : Int, private val getUserToDosUseCase: GetUserToDosUseCase) : ViewModel() {

    private var _todosLiveData : MutableLiveData<List<ToDo>> = MutableLiveData()
    val todosLiveData : LiveData<List<ToDo>> = _todosLiveData

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {
            val toDos = getUserToDosUseCase(userId)
            _todosLiveData.postValue(toDos)
        }
    }

}