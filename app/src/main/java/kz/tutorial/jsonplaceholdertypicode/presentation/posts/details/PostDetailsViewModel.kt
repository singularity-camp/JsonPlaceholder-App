package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import androidx.lifecycle.ViewModel
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostByIdUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostComments
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase

class PostDetailsViewModel(
    private val getPostByIdUseCase: GetPostByIdUseCase,
    private val getPostComments: GetPostComments,
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {

}