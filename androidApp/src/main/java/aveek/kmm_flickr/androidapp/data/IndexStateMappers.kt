package aveek.kmm_flickr.androidapp.data

import androidx.compose.runtime.mutableStateOf
import aveek.kmm_flickr.androidapp.domain.model.IndexStateMapper
import aveek.kmm_flickr.domain.model.remote.Photos

object IndexStateMappers {
    fun indexStateMappers(it: Photos): ArrayList<IndexStateMapper> {
        val tempList = arrayListOf<IndexStateMapper>()
        for (i in 0 until it.photo.size) {
            val indexStateMapper = IndexStateMapper(index = i, state = mutableStateOf(false))
            tempList.add(indexStateMapper)
        }
        return tempList
    }
}