package com.nicolasrf.botoneraperu.ui.detail

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.net.toUri
import com.nicolasrf.botoneraperu.ui.theme.BotoneraPeruTheme
import com.nicolasrf.botoneraperu.utils.toFirebaseUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {

    private lateinit var playSongUtils: PlaySongUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BotoneraPeruTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen(onPlayClick = {
                        playAudio(it.toFirebaseUrl())
                    }, onFavoriteClick = {

                    }, onBackClick = {
                        finish()
                    })
                }
            }
        }
        initPlaySongUtils()
    }

    private fun initPlaySongUtils() {
        playSongUtils = PlaySongUtils(this)
    }

    private fun playAudio(media: Uri) {
        playSongUtils.playAudio(media)
    }

}