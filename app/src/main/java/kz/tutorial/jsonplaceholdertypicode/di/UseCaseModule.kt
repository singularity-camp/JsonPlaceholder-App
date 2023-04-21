package kz.tutorial.jsonplaceholdertypicode.di

import kz.tutorial.jsonplaceholdertypicode.domain.use_cases.*
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get()) }
    factory { GetPostByIdUseCase(get()) }
    factory { GetPostCommentsUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { GetAlbumsUseCase(get()) }
    factory { GetUserShortUseCase(get()) }
    factory { GetToDoListUseCase(get()) }
    factory { GetPhotosUseCase(get()) }
    factory { GetAlbumByIdUseCase(get()) }
    factory { GetSubmitPostUseCase(get()) }
}