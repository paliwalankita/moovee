package com.ankita.tmdbclient.presentation.di.core

import com.ankita.tmdbclient.domain.repository.ArtistRepository
import com.ankita.tmdbclient.domain.repository.MovieRepository
import com.ankita.tmdbclient.domain.repository.TvShowsRepository
import com.ankita.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository: TvShowsRepository): GetTvShowsUseCase{
        return GetTvShowsUseCase(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowsRepository)
    }
}