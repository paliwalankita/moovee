package com.ankita.tmdbclient.data.repository.artist.datasourceImpl

import com.ankita.tmdbclient.data.api.TMDBService
import com.ankita.tmdbclient.data.model.artist.ArtistList
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String)
    : ArtistRemoteDataSource {
    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtist(apiKey)
    }

