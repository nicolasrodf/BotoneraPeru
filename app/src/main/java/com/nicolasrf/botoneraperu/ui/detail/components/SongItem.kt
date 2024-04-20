package com.nicolasrf.botoneraperu.ui.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nicolasrf.botoneraperu.domain.model.Song

@Composable
fun SongItem(
    song: Song,
    onPlayClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier
){
    Row(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PlayButton(
            onPlayClick = { onPlayClick() },
            modifier = modifier
        )
        Column(modifier = modifier.weight(2f).padding(8.dp)) {
            Text(
                text = song.singerName,
                fontSize = 18.sp,
                color = Color.Magenta,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = song.name,
                fontSize = 14.sp,
                color = Color.Green,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        FavoriteButton(
            onFavClick = { onFavoriteClick() },
            color = Color.White,
            modifier = modifier
        )
    }
}