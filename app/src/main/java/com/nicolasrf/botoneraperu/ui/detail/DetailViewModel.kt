package com.nicolasrf.botoneraperu.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nicolasrf.botoneraperu.di.SingerId
import com.nicolasrf.botoneraperu.usecases.CreateSingersUseCase
import com.nicolasrf.botoneraperu.usecases.GetSingerUseCase
import com.nicolasrf.botoneraperu.usecases.GetSingersUseCase
import com.nicolasrf.botoneraperu.usecases.GetSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    @SingerId private val singerId: Int,
    private val getSingerUseCase: GetSingerUseCase,
    private val getSongsUseCase: GetSongsUseCase
) : ViewModel() {

    var state by mutableStateOf(DetailState())
        private set

    init {
        viewModelScope.launch {
            getSingerUseCase(singerId).collectLatest { singer ->
                getSongsUseCase(singerId).collectLatest { songs ->
                    state = state.copy(
                        songs = songs.map {
                            it.copy(
                                singerName = singer.name
                            )
                        },
                        singerName = singer.name
                    )
                }
            }

    }

}