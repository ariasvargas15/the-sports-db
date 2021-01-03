package com.brayanarias.thesportsdb.presentation

import com.brayanarias.thesportsdb.GetTeamsByLeague
import com.brayanarias.thesportsdb.data.repository.SportsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
internal class MyModule {
    @Provides
    fun getTeamsByLeague(sportsRepository: SportsRepository) =
        GetTeamsByLeague(sportsRepository)
}