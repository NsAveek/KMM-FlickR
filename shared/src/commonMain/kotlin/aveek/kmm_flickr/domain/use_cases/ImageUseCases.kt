package aveek.kmm_flickr.domain.use_cases

import aveek.kmm_flickr.domain.use_cases.download.DownloadImageUseCase
import aveek.kmm_flickr.domain.use_cases.image_fetch.GetImagesFromServerUseCase

data class ImageUseCases(
    val fetchImages : GetImagesFromServerUseCase,
    val downloadImages: DownloadImageUseCase
)