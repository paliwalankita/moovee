package com.ankita.tmdbclient.data.repository.tvshows.datasource

import com.ankita.tmdbclient.data.model.tvshows.TvShow

interface TvShowsCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}