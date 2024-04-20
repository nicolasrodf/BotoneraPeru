package com.nicolasrf.botoneraperu.usecases

import com.nicolasrf.botoneraperu.domain.model.Singer
import com.nicolasrf.botoneraperu.domain.repository.AudioRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingerUseCase @Inject constructor(
    private val audioRepository: AudioRepository
) {

    operator fun invoke(singerId: Int) : Flow<Singer> {
        return audioRepository.getSinger(singerId)
    }
}