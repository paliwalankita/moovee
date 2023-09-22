package com.ankita.tmdbclient.presentation.di.core

import com.ankita.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.ankita.tmdbclient.presentation.di.movie.MovieSubComponent
import com.ankita.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
CacheDataModule::class,
DatabaseModule::class,
LocalDataModule::class,
NetModule::class,
RemoteDataModule::class,
RepositoryModule::class,
UseCaseModule::class
])
interface AppComponent {
    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
}