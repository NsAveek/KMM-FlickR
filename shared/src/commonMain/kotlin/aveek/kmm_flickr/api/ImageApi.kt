package aveek.kmm_flickr.api

import aveek.kmm_flickr.NetworkParameters
import aveek.kmm_flickr.domain.model.remote.FlickrBase
import aveek.kmm_flickr.domain.model.remote.Photos
import aveek.kmm_flickr.domain.repository.ImageRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

const val baseUrl = "https://api.flickr.com/services/rest?"
const val methodSearch = "flickr.photos.search"
const val itemPerPage = 21
const val pageNumber = 1

class ImageApi (private val httpClient: HttpClient) : ImageRepository {
    @Throws(Exception::class)
    override suspend fun fetchImage(query : String): Photos? {
        val data: FlickrBase =
            httpClient.get(
                "$baseUrl" +
                        "api_key=${NetworkParameters.apiKey}&" +
                        "method=${methodSearch}&" +
                        "tags=$query&" +
                        "format=json&" +
                        "nojsoncallback=true&" +
                        "extras=media&" +
                        "extras=url_w&" +
                        "per_page=${itemPerPage}&" +
                        "page=${pageNumber}"
            ).body()
        return data.photos
    }

    override suspend fun downloadImage(mediaUrl: String): Photos? {
        // TODO: download code goes here
        return null
    }

}