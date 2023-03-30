package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.presentation.comments.PostCommentsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.PostDetailsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        PostsViewModel(get())
    }
    viewModel {(postId:Int)->
        PostDetailsViewModel(
            postId = postId,
            getPostDetailsUseCase = get(),
            getCommentsUseCase = get(),
            getUserUseCase = get()
        )
    }
    viewModel {(postId: Int)->
        PostCommentsViewModel(
            postId = postId,
            getCommentsUseCase = get()
        )
    }
}