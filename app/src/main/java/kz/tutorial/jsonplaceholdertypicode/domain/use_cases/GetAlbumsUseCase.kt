package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Album
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumsRepository

class GetAlbumsUseCase(
    private val albumsRepository: AlbumsRepository
) {
    suspend operator fun invoke(): List<Album> {
        return albumsRepository.getAlbums()
    }
}