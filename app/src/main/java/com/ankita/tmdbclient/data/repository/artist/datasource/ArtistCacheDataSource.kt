package com.ankita.tmdbclient.data.repository.artist.datasource

import com.ankita.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache(): List<Artist>
    suspend fun saveArtistToCache(artist: List<Artist>)
}