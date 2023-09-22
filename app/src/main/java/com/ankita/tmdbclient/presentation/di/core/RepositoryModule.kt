package com.ankita.tmdbclient.presentation.di.core

import com.ankita.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.ankita.tmdbclient.data.repository.movies.MovieRepositoryImpl
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieCacheDataSource
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieLocalDataSource
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieRemoteDataSource
import com.ankita.tmdbclient.data.repository.tvshows.TvShowsRepositoryImpl
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsCacheDataSource
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsLocalDataSource
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsRemoteDataSource
import com.ankita.tmdbclient.domain.repository.ArtistRepository
import com.ankita.tmdbclient.domain.repository.MovieRepository
import com.ankita.tmdbclient.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository{
        return MovieRepositoryImpl(
            movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowsRepository(
        tvShowsRemoteDataSource: TvShowsRemoteDataSource,
        tvShowsLocalDataSource: TvShowsLocalDataSource,
        tvShowsCacheDataSource: TvShowsCacheDataSource
    ): TvShowsRepository{
        return TvShowsRepositoryImpl(
            tvShowsRemoteDataSource, tvShowsLocalDataSource, tvShowsCacheDataSource)
    }
}