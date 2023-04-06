package kz.tutorial.jsonplaceholdertypicode.presentation.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.models.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetCommentsUseCase

class PostCommentsViewModel(
    private val postId: Int,
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {


    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> = _comments

    init {
        getComments()
    }

    private fun getComments() {
        viewModelScope.launch {
            val commentsList = getCommentsUseCase(postId)
            _comments.postValue(commentsList)
        }
    }
}