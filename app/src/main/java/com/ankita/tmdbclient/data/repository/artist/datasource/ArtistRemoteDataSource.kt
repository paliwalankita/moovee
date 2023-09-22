package com.ankita.tmdbclient.data.repository.artist.datasource

import com.ankita.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtist(): Response<ArtistList>
}