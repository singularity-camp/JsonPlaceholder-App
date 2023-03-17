package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostCommentsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostDetailsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        PostsViewModel(get())
    }
    viewModel {
        PostDetailsViewModel(get(), get())
    }
    viewModel {
        PostCommentsViewModel(get())
    }
}
