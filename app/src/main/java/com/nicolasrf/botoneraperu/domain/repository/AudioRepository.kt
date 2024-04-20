package com.nicolasrf.botoneraperu.domain.repository

import com.nicolasrf.botoneraperu.domain.model.Singer
import com.nicolasrf.botoneraperu.domain.model.Song
import kotlinx.coroutines.flow.Flow

interface AudioRepository {

    suspend fun insertSinger(singer: Singer)

    suspend fun insertSingers(singers: List<Singer>)

    suspend fun insertSong(song: Song)

    suspend fun insertSongs(songs: List<Song>)

    fun getAllSingers() : Flow<List<Singer>>

    fun getAllSongsBySinger(id: Int): Flow<List<Song>>

    fun getSinger(id: Int): Flow<Singer>

}