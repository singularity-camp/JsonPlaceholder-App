package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumRepository

class GetAlbumUseCase(private val albumsRepository: AlbumRepository) {
    suspend operator fun invoke(albumId: Int): Album {
        return albumsRepository.getAlbum(albumId)
    }
}