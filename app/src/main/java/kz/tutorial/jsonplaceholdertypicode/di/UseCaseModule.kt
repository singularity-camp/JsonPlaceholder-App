package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostByIdUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostComments
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostsUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
    factory { GetPostByIdUseCase(get()) }
    factory { GetPostComments(get()) }
    factory { GetUserUseCase(get()) }
}