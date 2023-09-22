package com.ankita.tmdbclient.presentation

import android.app.Application
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.builder
import com.ankita.tmdbclient.BuildConfig
import com.ankita.tmdbclient.presentation.di.Injector
import com.ankita.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.ankita.tmdbclient.presentation.di.core.*
import com.ankita.tmdbclient.presentation.di.movie.MovieSubComponent
import com.ankita.tmdbclient.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import dagger.android.DaggerApplication
import dagger.internal.MapFactory.builder
import java.util.stream.DoubleStream.builder

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        // Instance of the AppComponent that will be used by all the Activities in the project

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}