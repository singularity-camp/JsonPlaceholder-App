package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.AlbumsRepository

class GetAlbumPhotosUseCase(private val albumsRepository: AlbumsRepository) {

    suspend operator fun invoke(albumId : Int) : List<Photo> {
        return albumsRepository.getAlbumPhotos(albumId)
    }
}