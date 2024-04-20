package com.nicolasrf.botoneraperu.data.repository

import com.nicolasrf.botoneraperu.data.local.AudioDao
import com.nicolasrf.botoneraperu.data.mapper.AudioMapper.toDomain
import com.nicolasrf.botoneraperu.data.mapper.AudioMapper.toEntity
import com.nicolasrf.botoneraperu.domain.model.Singer
import com.nicolasrf.botoneraperu.domain.model.Song
import com.nicolasrf.botoneraperu.domain.repository.AudioRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AudioRepositoryImpl @Inject constructor(
    private val audioDao: AudioDao
) : AudioRepository {

    override suspend fun insertSinger(singer: Singer) {
        audioDao.insertSinger(singer.toEntity())
    }

    override suspend fun insertSingers(singers: List<Singer>) {
        audioDao.insertSingers(singers.map { it.toEntity() })
    }

    override suspend fun insertSong(song: Song) {
        audioDao.insertSong(song.toEntity())
    }

    override suspend fun insertSongs(songs: List<Song>) {
        audioDao.insertSongs(songs.map { it.toEntity() })
    }

    override fun getAllSingers(): Flow<List<Singer>> {
        return audioDao.getAllSingers().map { list ->
            list.map { it.toDomain() }
        }
    }

    override fun getAllSongsBySinger(id: Int): Flow<List<Song>> {
        return audioDao.getAllSongsBySinger(id).map { list ->
            list.map { it.toDomain() }
        }
    }

    override fun getSinger(id: Int): Flow<Singer> {
        return audioDao.getSinger(id).map { it.toDomain() }
    }
}