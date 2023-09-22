package com.ankita.tmdbclient.domain.repository

import com.ankita.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}