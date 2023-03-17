package kz.tutorial.jsonplaceholdertypicode.presentation.posts.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CommentsViewModel : ViewModel() {
    private val _commentsLiveData: MutableLiveData<List<Comment>> = MutableLiveData()
    val commentsLiveData: LiveData<List<Comment>> = _commentsLiveData

    fun setPostID(ID: Int?) {
        if (ID != null) {
            viewModelScope.launch {
                val commentList: List<Comment> = CommentRetrofitBuilder.commentAPIService.getCommentsList(ID)
                _commentsLiveData.postValue(commentList)
            }
        }
    }
}