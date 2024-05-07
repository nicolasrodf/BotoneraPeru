package com.nicolasrf.botoneraperu.ui.detail

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri

class PlaySongUtils(
    private val context: Context
) {

    private var isSelectStop = true
    private var mediaPlayer: MediaPlayer? = null

    fun playAudio(songUri: Uri){
        if(isSelectStop){
            mediaPlayer = MediaPlayer.create(context,songUri)
            isSelectStop = false
        }
        mediaPlayer?.let {
            if(it.isPlaying){
                mediaPlayer?.stop()
                isSelectStop = true
            }
            it.start()
            it.setOnCompletionListener { mp ->
                mp.reset()
                isSelectStop = true
            }
        }
    }

}