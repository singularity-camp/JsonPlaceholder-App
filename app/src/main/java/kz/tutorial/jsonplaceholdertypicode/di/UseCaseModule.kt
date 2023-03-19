package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.GetPostsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
}