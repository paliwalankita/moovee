package com.ankita.tmdbclient.presentation.di.movie

import com.ankita.tmdbclient.domain.usecase.GetMoviesUseCase
import com.ankita.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.ankita.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}