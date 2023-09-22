package com.ankita.tmdbclient.data.repository.artist.datasourceImpl

import com.ankita.tmdbclient.data.model.artist.Artist
import com.ankita.tmdbclient.data.model.artist.ArtistList
import com.ankita.tmdbclient.data.model.movies.Movie
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.ankita.tmdbclient.data.repository.movies.datasource.MovieCacheDataSource

class ArtistCacheDataSourceImpl() : ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
       return artistList
    }

    override suspend fun saveArtistToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}

