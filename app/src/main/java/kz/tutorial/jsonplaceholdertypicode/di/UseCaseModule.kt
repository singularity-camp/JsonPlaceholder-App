package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.GetCurrPostUseCase
import kz.tutorial.jsonplaceholdertypicode.domain.GetPostsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
    factory { GetCurrPostUseCase(get()) }
}