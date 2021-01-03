package com.brayanarias.thesportsdb.framework.di

import com.brayanarias.thesportsdb.data.repository.SportsRepository
import com.brayanarias.thesportsdb.data.source.LocalDataSource
import com.brayanarias.thesportsdb.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun sportsRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
        @Named("apiKey") apiKey: String
    ) = SportsRepository(localDataSource, remoteDataSource, apiKey)
}