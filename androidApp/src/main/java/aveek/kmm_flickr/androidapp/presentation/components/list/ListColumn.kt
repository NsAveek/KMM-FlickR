package aveek.kmm_flickr.androidapp.presentation.components.list

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import aveek.kmm_flickr.androidapp.domain.actions.Events
import aveek.kmm_flickr.androidapp.domain.states.DataFetchStates
import aveek.kmm_flickr.androidapp.presentation.MainViewModel
import aveek.kmm_flickr.androidapp.presentation.util.Screens
import aveek.kmm_flickr.domain.model.remote.Photo

@Composable
internal fun ScrollableListColumn(
    navController: NavController,
    state: DataFetchStates,
    context: Context,
    viewModel: MainViewModel,
    data: List<Photo>
) {
    val lazyListState = rememberLazyListState()

    LazyColumn(
        state = lazyListState, modifier = Modifier.fillMaxHeight(),
    ) {
        itemsIndexed(items = data){ index, photo ->
            ListItem(state = state, index= index, item = photo,  onItemClick = {
                viewModel.onAction(Events.selectListItem(index))
            }, onDownloadClick = {
//                viewModel.onAction(Events.downloadSelectedListItem(index = index, mediaUrl = photo.url_w))
                Toast.makeText(context, "Download Clicked ", Toast.LENGTH_SHORT).show()
            }, onPhotoClick ={
                navController.navigate(Screens.DetailsScreen.withArgs("$index"))
            })
        }
    }
}
