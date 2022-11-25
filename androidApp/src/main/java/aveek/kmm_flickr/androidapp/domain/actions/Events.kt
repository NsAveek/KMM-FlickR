package aveek.kmm_flickr.androidapp.domain.actions

sealed class Events{
    data class search (val query : String) : Events()
    data class selectListItem (val index : Int) : Events()
    data class downloadSelectedListItem (val index : Int, val mediaUrl : String) : Events()
}