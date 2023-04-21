package kz.tutorial.jsonplaceholdertypicode.presentation.posts.newpost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.models.Post
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetSubmitPostUseCase

class NewPostViewModel(private val getSubmitPostUseCase: GetSubmitPostUseCase) : ViewModel() {

    private val _postsLiveData: MutableLiveData<Post> = MutableLiveData()
    val postsLiveData: LiveData<Post> = _postsLiveData

    fun submitPost(title: String, body: String) {
        viewModelScope.launch {
            val resultPost = getSubmitPostUseCase(title = title, body = body)
            _postsLiveData.postValue(resultPost)
        }
    }

}