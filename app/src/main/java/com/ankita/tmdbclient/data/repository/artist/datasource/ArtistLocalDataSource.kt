package com.ankita.tmdbclient.data.repository.artist.datasource

import com.ankita.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistFromDB(): List<Artist>
    suspend fun saveArtistToDB(artist: List<Artist>)
    suspend fun clearAll()
}