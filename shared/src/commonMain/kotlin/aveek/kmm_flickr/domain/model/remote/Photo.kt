package aveek.kmm_flickr.domain.model.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photo(
    @SerialName("id") var id: String,
    @SerialName("owner") var owner: String,
    @SerialName("secret") var secret: String,
    @SerialName("server") var server: String,
    @SerialName("farm") var farm: Int,
    @SerialName("title") var title: String,
    @SerialName("ispublic") var ispublic: Int,
    @SerialName("isfriend") var isfriend: Int,
    @SerialName("isfamily") var isfamily: Int,
    @SerialName("url_w") var url_w: String,
    @SerialName("height_w") var height_w: String,
    @SerialName("width_w") var width_w: String



)
