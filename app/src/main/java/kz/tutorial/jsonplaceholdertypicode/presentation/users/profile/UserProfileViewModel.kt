package kz.tutorial.jsonplaceholdertypicode.presentation.users.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase

class UserProfileViewModel(private val userId: Int, private val getUserUseCase: GetUserUseCase) :
    ViewModel() {
    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> = _userProfile

    init {
        getUserProfile()
    }

    private fun getUserProfile() {
        viewModelScope.launch {
            val user = getUserUseCase(userId = userId)
            _userProfile.postValue(user)
        }
    }
}