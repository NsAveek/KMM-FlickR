package aveek.kmm_flickr.androidapp.domain.model

import androidx.compose.runtime.MutableState

data class IndexStateMapper (val index : Int, val state : MutableState<Boolean>){
    fun toggle(){
        state.value = !state.value
    }
}