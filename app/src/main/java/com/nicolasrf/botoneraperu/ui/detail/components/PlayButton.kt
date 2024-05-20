package com.nicolasrf.botoneraperu.ui.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nicolasrf.botoneraperu.ui.theme.Red1
import com.nicolasrf.botoneraperu.ui.theme.Red2
import com.nicolasrf.botoneraperu.ui.theme.Red3

@Composable
fun PlayButton(
    onPlayClick: () -> Unit,
    modifier: Modifier
){

    val ringGradient = arrayOf(
        0.0f to Color.LightGray,
        0.2f to Color.Gray,
        1f to Color.DarkGray
    )

    val buttonGradient = arrayOf(
        0.0f to Red1,
        0.2f to Red2,
        1f to Red3
    )

    Box(
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(Brush.verticalGradient(colorStops = ringGradient)),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
                .background(Brush.radialGradient(colorStops = buttonGradient))
                .clickable { onPlayClick() },
            contentAlignment = Alignment.Center
        ) {}
    }
}