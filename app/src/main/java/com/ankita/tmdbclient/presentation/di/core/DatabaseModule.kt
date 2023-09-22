package com.ankita.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.ankita.tmdbclient.data.db.ArtistDao
import com.ankita.tmdbclient.data.db.MovieDao
import com.ankita.tmdbclient.data.db.TMDBDatabase
import com.ankita.tmdbclient.data.db.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowsDao{
        return tmdbDatabase.tvShowsDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao{
        return tmdbDatabase.artistDao()
    }
}