package com.ankita.tmdbclient.presentation.di.core

import androidx.room.PrimaryKey
import com.ankita.tmdbclient.data.api.TMDBService
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.ankita.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieRemoteDataSource
import com.ankita.tmdbclient.data.repository.movies.datasourceImpl.MovieRemoteDataSourceImpl
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsRemoteDataSource
import com.ankita.tmdbclient.data.repository.tvshows.datasourceImpl.TvShowsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowsRemoteDataSource(tmdbService: TMDBService): TvShowsRemoteDataSource{
        return TvShowsRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}