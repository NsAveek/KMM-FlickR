package aveek.kmm_flickr.androidapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import aveek.kmm_flickr.androidapp.presentation.util.Screens

@Composable
fun Navigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ListScreen.route){
        composable(route = Screens.ListScreen.route){

        }
    }
}