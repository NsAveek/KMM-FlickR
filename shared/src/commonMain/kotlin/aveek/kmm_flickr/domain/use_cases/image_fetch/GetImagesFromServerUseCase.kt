package aveek.kmm_flickr.domain.use_cases.image_fetch

import aveek.kmm_flickr.domain.model.remote.Photos
import aveek.kmm_flickr.domain.repository.ImageRepository

class GetImagesFromServerUseCase (private val repository: ImageRepository) {
    suspend operator fun invoke(query : String) : Photos? {
        return repository.fetchImage(query)
    }
}