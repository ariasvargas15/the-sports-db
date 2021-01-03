package com.brayanarias.thesportsdb.framework.di

import android.app.Application
import androidx.room.Room
import com.brayanarias.thesportsdb.R
import com.brayanarias.thesportsdb.data.source.LocalDataSource
import com.brayanarias.thesportsdb.data.source.RemoteDataSource
import com.brayanarias.thesportsdb.framework.db.RoomDataSource
import com.brayanarias.thesportsdb.framework.db.SportsDatabase
import com.brayanarias.thesportsdb.framework.network.SportsRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app: Application): String = app.getString(R.string.api_key)

    @Provides
    @Singleton
    fun databaseProvider(app: Application): SportsDatabase = Room.databaseBuilder(
        app,
        SportsDatabase::class.java,
        "sports-db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: SportsDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = SportsRemoteDataSource()
}