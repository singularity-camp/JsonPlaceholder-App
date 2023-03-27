package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PhotosRepository

class GetPhotosUseCase(private val photosRepository: PhotosRepository) {
    suspend operator fun invoke(albumId: Int): List<Photo> {
        return photosRepository.getAlbumPhotos(albumId)
    }
}