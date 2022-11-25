package aveek.kmm_flickr.androidapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import aveek.kmm_flickr.androidapp.data.IndexStateMappers.indexStateMappers
import aveek.kmm_flickr.androidapp.domain.actions.Events
import aveek.kmm_flickr.androidapp.domain.states.DataFetchStates
import aveek.kmm_flickr.androidapp.domain.util.Utils.DEFAULT_QUERY
import aveek.kmm_flickr.domain.use_cases.ImageUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCases: ImageUseCases) : ViewModel() {

    var state by mutableStateOf(DataFetchStates())
        // For testing purpose, for the time being, changing the set method internal
        internal set


    init {
        getTheData(query = DEFAULT_QUERY)
    }

    fun onAction(action: Events) {
        when (action) {
            is Events.search -> {
                getTheData(action.query)
            }
            is Events.selectListItem -> {
                state.itemStates[action.index].apply { toggle() }
                state = state.copy(itemStates = state.itemStates)
            }
            is Events.downloadSelectedListItem -> {
                downloadImage(action.mediaUrl)
            }
        }
    }

    private fun downloadImage(mediaUrl: String) {
        GlobalScope.launch {
            useCases.downloadImages(mediaUrl)
        }
    }

    fun getTheData(query: String) {

        val stateQuery = state.query
        stateQuery.value = query
        state = state.copy(query = stateQuery)

        val stateLoading = state.loading

        viewModelScope.launch {
            try {
                val data = useCases.fetchImages(query)
                data?.let {
                    stateLoading.value = !stateLoading.value
                    state = state.copy(
                        loading = stateLoading,
                        data = it.photo,
                        itemStates = indexStateMappers(it)
                    )
                }
            } catch (e: Exception) {
                state = state.copy(
                    loading = stateLoading,
                    data = arrayListOf()
                )
                e.localizedMessage ?: "error"
            }
        }
    }
}