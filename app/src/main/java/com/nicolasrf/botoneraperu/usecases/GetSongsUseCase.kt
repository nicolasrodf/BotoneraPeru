package com.nicolasrf.botoneraperu.usecases

import com.nicolasrf.botoneraperu.domain.model.Song
import com.nicolasrf.botoneraperu.domain.repository.AudioRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSongsUseCase @Inject constructor(
    private val audioRepository: AudioRepository
) {

    operator fun invoke(singerId: Int) : Flow<List<Song>> {
        return audioRepository.getAllSongsBySinger(singerId)
    }
}