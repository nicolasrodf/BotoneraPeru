package com.nicolasrf.botoneraperu.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SongEntity (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val singerId: Int,
    val trackUrl: String
)