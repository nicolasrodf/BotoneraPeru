package com.nicolasrf.botoneraperu.data.mapper

import com.nicolasrf.botoneraperu.data.entity.SingerEntity
import com.nicolasrf.botoneraperu.data.entity.SongEntity
import com.nicolasrf.botoneraperu.domain.model.Singer
import com.nicolasrf.botoneraperu.domain.model.Song

object AudioMapper {

    fun Singer.toEntity() : SingerEntity {
        return SingerEntity(
            id = id,
            name = name,
            image = image
        )
    }

    fun SingerEntity.toDomain() : Singer {
        return Singer(
            id = id,
            name = name,
            image = image
        )
    }

    fun Song.toEntity() : SongEntity {
        return SongEntity(
            id = id,
            name = name,
            singerId = singerId,
            trackUrl = trackUrl
        )
    }

    fun SongEntity.toDomain() : Song {
        return Song(
            id = id,
            name = name,
            singerId = singerId,
            trackUrl = trackUrl
        )
    }

}