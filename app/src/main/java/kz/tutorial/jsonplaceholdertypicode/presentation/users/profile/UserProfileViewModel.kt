package kz.tutorial.jsonplaceholdertypicode.presentation.users.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.User
import kz.tutorial.jsonplaceholdertypicode.domain.models.UserShort
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase

class UserProfileViewModel(
    private val user: UserShort,
    private val getUserUseCase: GetUserUseCase
) :
    ViewModel() {
    private val _userProfile = MutableLiveData<User>()
    val userProfile: LiveData<User> = _userProfile

    private val _userID = MutableLiveData<Int>()
    val userID: LiveData<Int> = _userID

    init {
        getUserProfile()
        verifyUser()
    }

    private fun getUserProfile() {
        viewModelScope.launch {
            val user = getUserUseCase(userId = user.id)
            _userProfile.postValue(user)
        }
    }

    private fun verifyUser() {
        _userID.value = user.id
    }
}