package aveek.kmm_flickr.domain.model.remote
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Photos(

    @SerialName("page") var page: Int,
    @SerialName("pages") var pages: Int,
    @SerialName("perpage") var perpage: Int,
    @SerialName("total") var total: Int,
    @SerialName("photo") var photo: ArrayList<Photo> = arrayListOf()

)
