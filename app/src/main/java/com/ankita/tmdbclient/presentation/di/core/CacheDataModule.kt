package com.ankita.tmdbclient.presentation.di.core

import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.ankita.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieCacheDataSource
import com.ankita.tmdbclient.data.repository.movies.datasourceImpl.MovieCacheDataSourceImpl
import com.ankita.tmdbclient.data.repository.tvshows.datasource.TvShowsCacheDataSource
import com.ankita.tmdbclient.data.repository.tvshows.datasourceImpl.TvShowsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource{
        return ArtistCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowsCacheDataSource(): TvShowsCacheDataSource{
        return TvShowsCacheDataSourceImpl()
    }
}