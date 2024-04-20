package com.nicolasrf.botoneraperu.di

import android.content.Context
import androidx.room.Room
import com.nicolasrf.botoneraperu.data.local.AudioDao
import com.nicolasrf.botoneraperu.data.local.AudioDatabase
import com.nicolasrf.botoneraperu.data.repository.AudioRepositoryImpl
import com.nicolasrf.botoneraperu.domain.repository.AudioRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideAudioDao(@ApplicationContext context: Context): AudioDao {
        return Room.databaseBuilder(
            context,
            AudioDatabase::class.java,
            "habits_db"
        ).build().dao
    }

    @Singleton
    @Provides
    fun provideAudioRepository(audioDao: AudioDao): AudioRepository {
        return AudioRepositoryImpl(audioDao)
    }
}