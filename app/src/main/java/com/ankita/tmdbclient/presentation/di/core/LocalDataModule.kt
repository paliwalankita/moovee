package com.ankita.tmdbclient.presentation.di.core

import com.ankita.tmdbclient.data.db.ArtistDao
import com.ankita.tmdbclient.data.db.MovieDao
import com.ankita.tmdbclient.data.db.TvShowsDao
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.ankita.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieLocalDataSource
import com.ankita.tmdbclient.data.repository.movies.datasourceImpl.MovieLocalDataSourceImpl
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsLocalDataSource
import com.ankita.tmdbclient.data.repository.tvshows.datasourceImpl.TvShowsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule{
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowsLocalDataSource(tvShowsDao: TvShowsDao): TvShowsLocalDataSource{
        return TvShowsLocalDataSourceImpl(tvShowsDao)
    }

}