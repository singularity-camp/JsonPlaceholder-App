package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.*
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
    factory { GetPostDetailsUseCase(get()) }
    factory { GetCommentsUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetUsersUseCase(get()) }
    factory { GetAlbumsUseCase(get()) }
    factory { GetAlbumPhotosUseCase(get()) }
    factory { GetRemoteAlbumByIdUseCase(get()) }
    factory { GetToDoUseCase(get()) }
}