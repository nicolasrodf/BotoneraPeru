package com.nicolasrf.botoneraperu.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicolasrf.botoneraperu.usecases.CreateSingersUseCase
import com.nicolasrf.botoneraperu.usecases.CreateSongsUseCase
import com.nicolasrf.botoneraperu.usecases.GetSingersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createSingersUseCase: CreateSingersUseCase,
    private val createSongsUseCase: CreateSongsUseCase,
    private val getSingersUseCase: GetSingersUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        createSingersAndSongs()
        viewModelScope.launch {
            getSingersUseCase().collectLatest {
                state = state.copy(
                    singers = it
                )
            }
        }
    }

    private fun createSingersAndSongs(){
        viewModelScope.launch {
            createSingersUseCase()
            createSongsUseCase()
        }
    }

}