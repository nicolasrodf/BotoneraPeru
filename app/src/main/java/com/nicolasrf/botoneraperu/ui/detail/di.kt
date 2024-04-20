package com.nicolasrf.botoneraperu.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.nicolasrf.botoneraperu.di.SingerId
import com.nicolasrf.botoneraperu.navigation.NavArgs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DetailViewModelModule {

    @Provides
    @ViewModelScoped
    @SingerId
    fun provideSingerId(savedStateHandle: SavedStateHandle): Int {
        return savedStateHandle[NavArgs.ItemId.key] ?: -1
    }

}