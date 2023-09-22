package com.ankita.tmdbclient.data.repository.artist

import android.util.Log
import com.ankita.tmdbclient.data.model.artist.Artist
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.ankita.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.ankita.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfMovies = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newListOfMovies)
        artistCacheDataSource.saveArtistToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getArtistFromApi(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            val response = artistRemoteDataSource.getArtist()
            val body = response.body()
            if(body != null){
                artistList = body.artists
            }
        }catch(exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch(exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch(exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if(artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistToCache(artistList)
        }
        return artistList
    }
}