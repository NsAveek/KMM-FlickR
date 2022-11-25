package aveek.kmm_flickr.api

import io.ktor.client.*

expect class HttpClientFactory {
    fun build() : HttpClient
}