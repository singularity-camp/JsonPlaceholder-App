package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.presentation.albums.AlbumsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.photos.PhotosViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.comments.CommentsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.PostDetailsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.newpost.NewPostViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.users.UsersViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.users.profile.UserProfileViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.users.todo.ToDoViewModel
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
    viewModel {
        AlbumsViewModel(get())
    }
    viewModel {
        UsersViewModel(get())
    }
    viewModel { (userId: Int, currentUserId: Int) ->
        UserProfileViewModel(
            userId = userId,
            currentUserId = currentUserId,
            getUserUseCase = get()
        )
    }
    viewModel { (userId: Int) ->
        ToDoViewModel(userId = userId, getToDoListUseCase = get())
    }
    viewModel { (albumId: Int) ->
        PhotosViewModel(
            albumId = albumId,
            getPhotosUseCase = get(),
            getAlbumByIdUseCase = get()
        )
    }
    viewModel {
        NewPostViewModel(get())
    }
}