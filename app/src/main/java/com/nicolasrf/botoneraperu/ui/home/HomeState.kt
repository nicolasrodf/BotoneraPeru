package com.nicolasrf.botoneraperu.ui.home

import com.nicolasrf.botoneraperu.domain.model.Singer

data class HomeState(
    val singers: List<Singer> = emptyList()
)
