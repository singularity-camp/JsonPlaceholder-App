package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetCommentsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostDetailsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
    factory { GetPostDetailsUseCase(get()) }
    factory { GetCommentsUseCase(get()) }
    factory { GetUserUseCase(get()) }
}