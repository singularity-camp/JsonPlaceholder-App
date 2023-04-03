package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumsRepository

class GetAlbumByIdUseCase(private val albumsRepository: AlbumsRepository) {

    suspend operator fun invoke(albumId : Int) : Album {
        return albumsRepository.getAlbumById(albumId)
    }
}