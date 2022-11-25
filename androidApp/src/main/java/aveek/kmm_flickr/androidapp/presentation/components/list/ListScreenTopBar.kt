@file:OptIn(ExperimentalMaterial3Api::class)

package aveek.kmm_flickr.androidapp.presentation.components.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import aveek.kmm_flickr.androidapp.domain.actions.Events
import aveek.kmm_flickr.androidapp.domain.states.DataFetchStates
import aveek.kmm_flickr.androidapp.presentation.MainViewModel

@Composable
internal fun ListScreenTopBar(state: DataFetchStates, viewModel: MainViewModel) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Gray)) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp),
            value = state.query.value,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            textStyle = TextStyle(color = Color.Black),
            label = { Text(text = "Search") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            },
            onValueChange = { newValue ->
                viewModel.onAction(Events.search(newValue))
            },
        )
    }
}