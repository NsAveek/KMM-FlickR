package aveek.kmm_flickr.androidapp.domain.states

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import aveek.kmm_flickr.androidapp.domain.model.IndexStateMapper
import aveek.kmm_flickr.androidapp.domain.util.Utils.DEFAULT_QUERY
import aveek.kmm_flickr.domain.model.remote.Photo

data class DataFetchStates(
   val data : List<Photo> = arrayListOf(),
   val loading : MutableState<Boolean> = mutableStateOf(true),
   val success : Boolean = false,
   val error : Boolean = false,
   var query : MutableState<String> = mutableStateOf( DEFAULT_QUERY),
   val itemStates : MutableList<IndexStateMapper> = arrayListOf()
)
