package aveek.kmm_flickr.domain.use_cases.download

import aveek.kmm_flickr.domain.model.remote.Photos
import aveek.kmm_flickr.domain.repository.ImageRepository


class DownloadImageUseCase (private val repository: ImageRepository) {
    suspend operator fun invoke(mediaUrl : String) : Photos? {
        return repository.downloadImage(mediaUrl)
    }
}