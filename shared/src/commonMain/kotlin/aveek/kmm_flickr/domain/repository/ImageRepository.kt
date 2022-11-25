package aveek.kmm_flickr.domain.repository

import aveek.kmm_flickr.domain.model.remote.Photos

interface ImageRepository {
    @Throws(Exception::class)
    suspend fun fetchImage(query : String): Photos?

    @Throws(Exception::class)
    suspend fun downloadImage(mediaUrl : String): Photos?
}