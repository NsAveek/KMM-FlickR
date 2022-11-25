package aveek.kmm_flickr.androidapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.mutableStateOf
import aveek.kmm_flickr.androidapp.domain.actions.Events
import aveek.kmm_flickr.androidapp.domain.model.IndexStateMapper
import aveek.kmm_flickr.androidapp.domain.states.DataFetchStates
import aveek.kmm_flickr.androidapp.presentation.MainViewModel
import aveek.kmm_flickr.domain.use_cases.ImageUseCases
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class MainViewModelUnitTest {
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var dataFetchStates: DataFetchStates

    @Mock
    lateinit var imageUseCase: ImageUseCases

    @Mock
    lateinit var indexStateMapper: IndexStateMapper

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()


    lateinit var viewModel: MainViewModel


    var itemStates = arrayListOf<IndexStateMapper>().apply {
        this.add(IndexStateMapper(0, mutableStateOf(false)))
        this.add(IndexStateMapper(1, mutableStateOf(false)))
        this.add(IndexStateMapper(2, mutableStateOf(false)))
    }


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(imageUseCase)
        dataFetchStates = DataFetchStates(itemStates = itemStates)
    }

    @Test
    fun `click item in the list should toggle the state value`() {
        viewModel.state = dataFetchStates
        viewModel.onAction(Events.selectListItem(1))
        assertTrue(dataFetchStates.itemStates[1].state.value)
    }
    @Test
    fun `click item in the list should keep the other values false`() {
        viewModel.state = dataFetchStates
        viewModel.onAction(Events.selectListItem(2))
        assertFalse(dataFetchStates.itemStates[0].state.value)
    }
}