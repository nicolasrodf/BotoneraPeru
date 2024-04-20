package com.nicolasrf.botoneraperu.domain.model

data class Song(
    val id: Int,
    val name: String,
    val singerId: Int,
    val singerName: String = "",
    val trackUrl: String
){
    constructor(songId: Int, name: String, singerId: Int, trackUrl: String) : this (
        id = songId, name = name, singerId = singerId, trackUrl = trackUrl
    )
}