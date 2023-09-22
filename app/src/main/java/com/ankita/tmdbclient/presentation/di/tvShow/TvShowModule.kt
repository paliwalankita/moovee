package com.ankita.tmdbclient.presentation.di.tvShow

import com.ankita.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.ankita.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.ankita.tmdbclient.presentation.tvShows.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideMovieViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}