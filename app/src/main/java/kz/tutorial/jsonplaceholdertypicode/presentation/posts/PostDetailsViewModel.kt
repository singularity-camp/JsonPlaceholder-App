package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.*

class PostDetailsViewModel(
    private val getCurrPostUseCase: GetCurrPostUseCase,
    private val getCommentsUseCase: GetCommentsUseCase) : ViewModel() {

    private val _currPostLiveData: MutableLiveData<Post> = MutableLiveData()
    val currPostLiveData: LiveData<Post> = _currPostLiveData
    var userId : Int = 1

    private val _commentsLiveData : MutableLiveData<List<Comment>> = MutableLiveData()
    val commentsLiveData : LiveData<List<Comment>> = _commentsLiveData

    init {
        getCurrPost(userId)
        getComments(userId)
    }

    private fun getCurrPost(id : Int) {
        viewModelScope.launch {
            val post = getCurrPostUseCase(id = id)
            _currPostLiveData.postValue(post)
        }
    }

    private fun getComments(postId : Int) {
        viewModelScope.launch {
            val comments = getCommentsUseCase(postId)
            _commentsLiveData.postValue(comments)
        }
    }
}