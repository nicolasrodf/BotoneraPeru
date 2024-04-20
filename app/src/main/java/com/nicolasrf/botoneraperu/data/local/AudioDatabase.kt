package com.nicolasrf.botoneraperu.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nicolasrf.botoneraperu.data.entity.SingerEntity
import com.nicolasrf.botoneraperu.data.entity.SongEntity

@Database(entities = [SingerEntity::class, SongEntity::class], version = 1)
abstract class AudioDatabase : RoomDatabase() {
    abstract val dao: AudioDao
}