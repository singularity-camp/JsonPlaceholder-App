package kz.tutorial.jsonplaceholdertypicode.presentation.user_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase

class UserProfileViewModel(private val userId : Int, private val getUserUseCase: GetUserUseCase) : ViewModel() {
    private var _currUser : MutableLiveData<User> = MutableLiveData()
    val currUser : LiveData<User> = _currUser

    init {
        getCurrUser()
    }

    private fun getCurrUser() {
        viewModelScope.launch {
            val user = getUserUseCase(userId = userId)
            _currUser.postValue(user)
        }
    }

}