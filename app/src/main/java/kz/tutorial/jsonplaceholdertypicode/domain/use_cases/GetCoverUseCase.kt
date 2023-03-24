package kz.tutorial.jsonplaceholdertypicode.domain.use_cases

import kz.tutorial.jsonplaceholdertypicode.domain.models.Photo
import kz.tutorial.jsonplaceholdertypicode.domain.repositories.PhotosRepository

class GetCoverUseCase(private val photosRepository: PhotosRepository) {
    suspend operator fun invoke(albumId: Int) : Photo {
        return photosRepository.getCover(albumId)
    }
}