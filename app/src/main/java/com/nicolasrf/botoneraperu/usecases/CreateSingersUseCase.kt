package com.nicolasrf.botoneraperu.usecases

import com.nicolasrf.botoneraperu.domain.model.Singer
import com.nicolasrf.botoneraperu.domain.repository.AudioRepository
import javax.inject.Inject

class CreateSingersUseCase @Inject constructor(
    private val audioRepository: AudioRepository
) {
    suspend operator fun invoke() {
        audioRepository.insertSingers(listOf(
            Singer(1,"PPK", "ppk.webp"),
            Singer(2,"Alan", "alan_garcia.webp"),
            Singer(3,"Cesar", "cesar_acuna.webp"),
            Singer(4,"Random", "random.webp"),
            Singer(5,"Melcochita", "melcochita.webp"),
            Singer(6,"Felpudini", "felpudini.webp"),
            Singer(7,"Gemelos", "gemelos.webp"),
            Singer(8,"Fails", "nigga.webp"),
            Singer(9,"Paisana", "paisana.webp"),
            Singer(10,"Susy", "susy.webp"),
        ))
    }
}