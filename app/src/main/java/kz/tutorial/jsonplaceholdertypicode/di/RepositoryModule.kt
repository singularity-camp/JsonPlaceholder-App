package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository
import kz.tutorial.jsonplaceholdertypicode.data.repositories.PostsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostsRepository> { PostsRepositoryImpl(get()) }
}