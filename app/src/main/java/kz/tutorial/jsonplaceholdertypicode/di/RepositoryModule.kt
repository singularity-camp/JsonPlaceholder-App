package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.data.repositories.*
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.*
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostsRepository> { PostsRepositoryImpl(get()) }
    factory<CommentsRepository> { CommentsRepositoryImpl(get()) }
    factory<UsersRepository> { UserRepositoryImpl(get()) }
    factory<AlbumsRepository> { AlbumsRepositoryImpl(get()) }
    factory<ToDoRepository> { ToDoRepositoryImpl(get()) }
}