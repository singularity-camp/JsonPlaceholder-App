package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumRepository

class GetAlbumsUseCase(private val albumsRepository: AlbumRepository) {
    suspend operator fun invoke(): List<Album> {
        return albumsRepository.getAlbums()
    }
}