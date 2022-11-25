package aveek.kmm_flickr.androidapp.presentation.components.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import aveek.kmm_flickr.androidapp.domain.states.DataFetchStates
import aveek.kmm_flickr.domain.model.remote.Photo
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListItem(
    state: DataFetchStates,
    index: Int,
    item: Photo,
    onItemClick: () -> Unit,
    onDownloadClick: () -> Unit,
    onPhotoClick: () -> Unit
) {

    Box {
        Card(modifier = Modifier
            .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .fillMaxHeight(),

            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            border = BorderStroke(
                2.dp,
                if (state.itemStates[index].state.value) Color.DarkGray else Color.White
            ),
            onClick = {
                onItemClick.invoke()
            }) {
            Column(modifier = Modifier.padding(16.dp)) {

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { onDownloadClick.invoke() }
                ) {
                    Text(text = "Download")
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
        Image(
            painter = rememberAsyncImagePainter(item.url_w),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(alignment = Alignment.TopEnd)
                .offset(x = (-40).dp)
                .clickable {
                    onPhotoClick.invoke()
                },
        )
    }

}