package com.nicolasrf.botoneraperu.usecases

import com.nicolasrf.botoneraperu.domain.model.Singer
import com.nicolasrf.botoneraperu.domain.repository.AudioRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingersUseCase @Inject constructor(
    private val audioRepository: AudioRepository
) {

    operator fun invoke() : Flow<List<Singer>> {
        return audioRepository.getAllSingers()
    }
}