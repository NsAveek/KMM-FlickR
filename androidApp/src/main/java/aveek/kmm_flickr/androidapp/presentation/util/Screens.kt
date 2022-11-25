package aveek.kmm_flickr.androidapp.presentation.util

sealed class Screens(val route: String) {
    object ListScreen : Screens("list_screen")
    object DetailsScreen : Screens("detail_screen")

    fun withArgs(vararg args : String) : String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
