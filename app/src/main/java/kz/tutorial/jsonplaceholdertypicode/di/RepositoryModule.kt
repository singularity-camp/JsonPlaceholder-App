package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.CommentsRepositoryImpl
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PostsRepository
import kz.tutorial.jsonplaceholdertypicode.data.PostsRepositoryImpl
import kz.tutorial.jsonplaceholdertypicode.data.UserRepositoryImpl
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.CommentsRepository
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostsRepository> { PostsRepositoryImpl(get()) }
    factory<CommentsRepository> { CommentsRepositoryImpl(get()) }
    factory<UserRepository> { UserRepositoryImpl(get()) }
}