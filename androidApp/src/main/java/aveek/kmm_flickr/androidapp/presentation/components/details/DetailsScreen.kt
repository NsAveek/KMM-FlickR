package aveek.kmm_flickr.androidapp.presentation.components.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import aveek.kmm_flickr.androidapp.domain.states.DataFetchStates
import aveek.kmm_flickr.androidapp.presentation.MainViewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailsScreen(
    id: Int,
    navController: NavController,
    viewModel: MainViewModel,
    state: DataFetchStates
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val photo = state.data[id]
        Row(modifier = Modifier.weight(0.4f)) {
            Image(
                painter = rememberAsyncImagePainter(photo.url_w),
                contentDescription = photo.title,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Row(modifier = Modifier
            .weight(1f)
            .background(color = Color.LightGray)) {
            Text(

                text = "${photo.title}",
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,
                    letterSpacing = 4.sp,
                    textAlign = TextAlign.Center,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(2f, 2f),
                        blurRadius = 1f
                    ),
                ),
            )
        }
    }
}