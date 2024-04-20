package com.nicolasrf.botoneraperu.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nicolasrf.botoneraperu.data.entity.SingerEntity
import com.nicolasrf.botoneraperu.data.entity.SongEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AudioDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSinger(singerEntity: SingerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSingers(singerEntity: List<SingerEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(songEntity: SongEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songEntity: List<SongEntity>)

    @Query("SELECT * FROM SongEntity WHERE singerId = :id")
    fun getAllSongsBySinger(id: Int): Flow<List<SongEntity>>

    @Query("SELECT * FROM SingerEntity WHERE id = :id")
    fun getSinger(id: Int): Flow<SingerEntity>

    @Query("SELECT * FROM SingerEntity")
    fun getAllSingers(): Flow<List<SingerEntity>>

   /* @Query("SELECT * FROM HabitEntity WHERE startDate <= :date ORDER BY id ASC")
    fun getAllHabitsForSelectedDate(date: Long): Flow<List<HabitEntity>>

    @Query("SELECT * FROM HabitEntity")
    fun getAllHabits(): List<HabitEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHabitSync(habitSyncEntity: HabitSyncEntity)

    @Query("SELECT * FROM HabitSyncEntity")
    fun getAllHabitsSync(): List<HabitSyncEntity>

    @Delete
    suspend fun deleteHabitSync(habitSyncEntity: HabitSyncEntity)*/
}