package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.GetCurrPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.Post

class PostDetailsViewModel(private val getCurrPostUseCase: GetCurrPostUseCase) : ViewModel() {

    private val _currPostLiveData: MutableLiveData<Post> = MutableLiveData()
    val currPostLiveData: LiveData<Post> = _currPostLiveData
    var userId : Int = 1

    init {
        getCurrPost(userId)
    }

    private fun getCurrPost(id : Int) {
        viewModelScope.launch {
            val post = getCurrPostUseCase(id = id)
            _currPostLiveData.postValue(post)
        }
    }
}