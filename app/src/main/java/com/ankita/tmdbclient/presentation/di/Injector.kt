package com.ankita.tmdbclient.presentation.di

import com.ankita.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.ankita.tmdbclient.presentation.di.movie.MovieSubComponent
import com.ankita.tmdbclient.presentation.di.tvShow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}