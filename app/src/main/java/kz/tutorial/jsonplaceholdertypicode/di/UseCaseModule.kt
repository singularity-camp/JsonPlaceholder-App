package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.*
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
    factory { GetPostByIdUseCase(get()) }
    factory { GetPostCommentsUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetAlbumsUseCase(get()) }
    factory { GetUsersUseCase(get()) }
    factory { GetUserToDosUseCase(get()) }
}