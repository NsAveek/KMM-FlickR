package aveek.kmm_flickr.androidapp.presentation

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import aveek.kmm_flickr.androidapp.presentation.components.details.DetailsScreen
import aveek.kmm_flickr.androidapp.presentation.components.list.ListScreen
import aveek.kmm_flickr.androidapp.presentation.theme.FlickRTheme
import aveek.kmm_flickr.androidapp.presentation.util.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var requestMultiplePermission: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestMultiplePermission = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            var isGranted = false
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                it.forEach { (s, b) ->
                    isGranted = b
                }
            } else {
                it.forEach { (s, b) ->
                    isGranted = b
                }
            }

            if (!isGranted) {
                Toast.makeText(this, "Permission Not Granted", Toast.LENGTH_SHORT).show()
            }
        }

        setContent {
            val viewModel = viewModel<MainViewModel>()
            var dataFetchStates = viewModel.state
            FlickRTheme() {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {

                    requestMultiplePermission.launch(
                        arrayOf(
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        )
                    )

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.ListScreen.route
                    ) {
                        composable(route = Screens.ListScreen.route) {
                            ListScreen(
                                navController = navController,
                                viewModel = viewModel,
                                context = LocalContext.current,
                                state = dataFetchStates
                            )
                        }
                        composable(
                            route = Screens.DetailsScreen.route +
                                    "/{itemId}",
                            arguments = listOf(
                                navArgument("itemId") {
                                    type = NavType.IntType
                                    defaultValue = 0
                                },
                            ),
                        ) { entry ->
                            DetailsScreen(
                                id = entry.arguments?.getInt("itemId") ?: 0,
                                navController = navController,
                                viewModel = viewModel,
                                state = dataFetchStates
                            )
                        }
                    }
                }
            }
        }
    }
}
