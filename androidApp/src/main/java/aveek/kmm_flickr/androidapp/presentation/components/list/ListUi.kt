@file:OptIn(ExperimentalMaterial3Api::class)

package aveek.kmm_flickr.androidapp.presentation.components.list


import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import aveek.kmm_flickr.androidapp.domain.states.DataFetchStates
import aveek.kmm_flickr.androidapp.presentation.MainViewModel


@Composable
fun ListScreen(
    context: Context,
    navController: NavController,
    viewModel: MainViewModel,
    state: DataFetchStates
) {
    Column(modifier = Modifier.fillMaxSize()) {
        ListScreenTopBar(state, viewModel)
        ScreenContent(
            navController,
            viewModel,
            context = context,
            state = state
        )
    }
}

@Composable
private fun ScreenContent(
    navController: NavController,
    viewModel: MainViewModel,
    context: Context,
    state: DataFetchStates,
) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ListLoaderHeader(context, data = state.loading.value)
        }

        Row(modifier = Modifier.fillMaxWidth()) {
            ScrollableListColumn(
                navController = navController,
                state = state,
                context = context,
                viewModel = viewModel,
                data = state.data
            )
        }
    }
}







