package aveek.kmm_flickr.data.repository

import aveek.kmm_flickr.api.ImageApi
import aveek.kmm_flickr.domain.model.remote.Photos
import aveek.kmm_flickr.domain.repository.ImageRepository

class ImageRepositoryImpl(val api : ImageApi ) :ImageRepository {
    override suspend fun fetchImage(query: String): Photos? {
        return api.fetchImage(query)
    }

    override suspend fun downloadImage(mediaUrl: String): Photos? {
        return api.downloadImage(mediaUrl)
    }
}