package kz.tutorial.jsonplaceholdertypicode.presentation.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.UserShort
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserShortUseCase

class UsersViewModel(private val getUsersShortUseCase: GetUserShortUseCase) : ViewModel() {
    private val _usersShort = MutableLiveData<List<UserShort>>()
    val usersShort: LiveData<List<UserShort>> = _usersShort

    init {
        getUsersShort()
    }

    private fun getUsersShort() {
        viewModelScope.launch {
            val usersShortList = getUsersShortUseCase()
            _usersShort.postValue(usersShortList)
        }
    }
}