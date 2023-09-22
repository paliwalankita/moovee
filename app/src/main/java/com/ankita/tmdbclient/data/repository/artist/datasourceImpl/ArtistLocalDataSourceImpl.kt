package com.ankita.tmdbclient.data.repository.artist.datasourceImpl

import com.ankita.tmdbclient.data.db.ArtistDao
import com.ankita.tmdbclient.data.db.MovieDao
import com.ankita.tmdbclient.data.model.artist.Artist
import com.ankita.tmdbclient.data.model.movies.Movie
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getArtist()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }

}

