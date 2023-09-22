package com.ankita.tmdbclient.data.repository.tvshows.datasource

import com.ankita.tmdbclient.data.model.tvshows.TvShow

interface TvShowsLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearAll()
}