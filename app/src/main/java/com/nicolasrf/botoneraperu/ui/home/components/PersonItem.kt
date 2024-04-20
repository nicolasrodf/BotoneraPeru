package com.nicolasrf.botoneraperu.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.nicolasrf.botoneraperu.domain.model.Singer
import com.nicolasrf.botoneraperu.utils.Utils.getBitmapFromAssets

@Composable
fun PersonItem(
    singer: Singer,
    onClick: () -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    getBitmapFromAssets(singer.image,context)?.asImageBitmap()?.let {
        Image(
            bitmap = it,
            contentDescription = "",
            modifier = modifier.clickable {
                onClick()
            }.clip(RoundedCornerShape(10.dp)),
        )
    }
}