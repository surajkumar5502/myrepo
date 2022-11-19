package com.tmdb.mymovies.di

import android.app.Application
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import com.tmdb.mymovies.model.datasource.LocalDataSource
import com.tmdb.mymovies.model.datasource.RemoteDataSource
import com.tmdb.mymovies.model.MovieRepository
import com.tmdb.mymovies.model.AppDatabase
import com.tmdb.mymovies.model.ApiService
import androidx.room.Room
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.tmdb.mymovies.util.Constants

@Module
class AppModule(private val application: Application) {
    @Singleton
    @Provides
    fun provideMovieRepository(
        localDataSource: LocalDataSource?,
        remoteDataSource: RemoteDataSource?
    ): MovieRepository {
        return MovieRepository(localDataSource!!, remoteDataSource!!)
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(appDatabase: AppDatabase): LocalDataSource {
        return LocalDataSource(appDatabase.movieDao())
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
        return RemoteDataSource(apiService)
    }

    @Singleton
    @Provides
    fun provideAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "movies-db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.IMDB_URL_BASE_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}