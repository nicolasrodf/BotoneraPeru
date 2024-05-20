package com.nicolasrf.botoneraperu.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.nicolasrf.botoneraperu.R
import com.nicolasrf.botoneraperu.ui.detail.components.SongItem
import com.nicolasrf.botoneraperu.ui.home.components.PersonItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    onPlayClick: (String) -> Unit,
    onFavoriteClick: () -> Unit,
    onBackClick: () -> Unit
) {
    val state = viewModel.state
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = state.singerName)
            }, navigationIcon = {
                IconButton(onClick = { onBackClick()}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                }
            })
        }
    ) {
        Box(
            Modifier
                .fillMaxSize().padding(it)
                .paint(
                    painterResource(id = R.drawable.fondo_rayas_botonera_app),
                    contentScale = ContentScale.FillBounds
                )
        ) {
            LazyColumn {
                items(state.songs) { song ->
                    SongItem(
                        song = song,
                        onPlayClick = {
                            onPlayClick(it)
                        },
                        onFavoriteClick = { },
                        modifier = Modifier
                    )
                }
            }
        }
    }
}