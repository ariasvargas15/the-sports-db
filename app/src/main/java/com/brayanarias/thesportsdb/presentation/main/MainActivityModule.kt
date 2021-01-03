package com.brayanarias.thesportsdb.presentation.main

import com.brayanarias.thesportsdb.GetTeamsByLeague
import com.brayanarias.thesportsdb.data.repository.SportsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
internal class MainActivityModule {
    @Provides
    fun getTeamsByLeague(sportsRepository: SportsRepository) =
        GetTeamsByLeague(sportsRepository)
}