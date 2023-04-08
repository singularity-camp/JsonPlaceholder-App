package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.presentation.albums.AlbumsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.comments.CommentsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.curr_profile.CurrProfileViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.curr_profile.ToDosViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.PostDetailsViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.user_profile.UserProfileViewModel
import kz.tutorial.jsonplaceholdertypicode.presentation.users.UsersFragmentViewmodel
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
        UsersFragmentViewmodel(get())
    }

    viewModel {(userId: Int) ->
        UserProfileViewModel(
            userId = userId,
            getUserUseCase = get()
        )
    }

    viewModel { (userId: Int) ->
        CurrProfileViewModel(
            userId = userId,
            getUserUseCase = get()
        )
    }

    viewModel {(userId : Int) ->
        ToDosViewModel(
            userId = userId,
            getUserToDosUseCase = get())
    }
}
