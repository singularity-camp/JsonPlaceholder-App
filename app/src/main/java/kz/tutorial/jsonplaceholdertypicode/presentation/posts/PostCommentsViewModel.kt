package kz.tutorial.jsonplaceholdertypicode.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.GetCommentsUseCase

class PostCommentsViewModel(private val getCommentsUseCase: GetCommentsUseCase) : ViewModel() {
    var userId : Int = 1

    private val _commentsLiveData : MutableLiveData<List<Comment>> = MutableLiveData()
    val commentsLiveData : LiveData<List<Comment>> = _commentsLiveData

    init {
        getComments(userId)
    }

    private fun getComments(postId : Int) {
        viewModelScope.launch {
            val comments = getCommentsUseCase(postId)
            _commentsLiveData.postValue(comments)
        }
    }
}