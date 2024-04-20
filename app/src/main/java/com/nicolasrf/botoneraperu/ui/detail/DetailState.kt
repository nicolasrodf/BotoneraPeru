package com.nicolasrf.botoneraperu.ui.detail

import com.nicolasrf.botoneraperu.domain.model.Song

data class DetailState(
    val singerName: String = "",
    val songs: List<Song> = emptyList()
)
