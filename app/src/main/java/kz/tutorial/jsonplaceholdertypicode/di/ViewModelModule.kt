package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.presentation.albums.AlbumPhotosViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.AlbumsViewmodel
import kz.tutorial.jsonplaceholdertypicode.presentation.comments.CommentsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.PostDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { PostsViewModel(get()) }
    viewModel { (postId: Int) -> //Так я позволяю передавать айди поста во время работы приложения
        PostDetailsViewModel(
            postId = postId,
            getPostByIdUseCase = get(),
            getPostCommentsUseCase = get(),
            getUserUseCase = get()
        )
    }
    viewModel { (postId: Int) ->
        CommentsViewModel(
            postId = postId,
            getPostCommentsUseCase = get()
        )
    }
    viewModel { AlbumsViewmodel(get()) }

    viewModel { (albumId : Int) ->
        AlbumPhotosViewModel(
            albumId = albumId,
            getAlbumPhotosUseCase = get(),
            getAlbumByIdUseCase = get()
        ) }
}