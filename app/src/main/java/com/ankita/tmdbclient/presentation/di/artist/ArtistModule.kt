package com.ankita.tmdbclient.presentation.di.artist

import com.ankita.tmdbclient.domain.usecase.GetArtistUseCase
import com.ankita.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.ankita.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }
}