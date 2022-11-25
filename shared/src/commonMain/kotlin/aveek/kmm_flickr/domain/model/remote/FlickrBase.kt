package aveek.kmm_flickr.domain.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class FlickrBase(
    @SerialName("photos") var photos: Photos,
    @SerialName("stat") var stat: String
)
