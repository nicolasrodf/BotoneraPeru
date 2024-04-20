package com.nicolasrf.botoneraperu.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.nicolasrf.botoneraperu.R
import com.nicolasrf.botoneraperu.ui.home.components.PersonItem

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onSingerClick: (Int) -> Unit
) {
    val state = viewModel.state
    Box(
        Modifier.fillMaxSize().paint(
            painterResource(id = R.drawable.fondo_rayas_botonera_app),
            contentScale = ContentScale.FillBounds
        )
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(state.singers) { person ->
                PersonItem(
                    singer = person,
                    onClick = { onSingerClick(person.id) },
                    modifier = Modifier
                )
            }
        }
    }
}