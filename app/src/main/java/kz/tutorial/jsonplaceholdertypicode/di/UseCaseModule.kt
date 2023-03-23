package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.usecases.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.usecases.GetPostDetailsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.usecases.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.usecases.GetUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
    factory { GetPostDetailsUseCase(get()) }
    factory { GetCommentsUseCase(get()) }
    factory { GetUserUseCase(get()) }
}