package com.ankita.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ankita.tmdbclient.data.model.artist.Artist
import com.ankita.tmdbclient.data.model.movies.Movie
import com.ankita.tmdbclient.data.model.tvshows.TvShow

@Database(entities = [Movie::class, Artist::class, TvShow::class],
version = 1,
exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun artistDao(): ArtistDao
    abstract fun tvShowsDao(): TvShowsDao
}