package com.brayanarias.thesportsdb.presentation.detail

import com.brayanarias.thesportsdb.GetEventsByTeam
import com.brayanarias.thesportsdb.data.repository.SportsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@Module
@InstallIn(ActivityRetainedComponent::class)
class DetailActivityModule {
    @Provides
    fun getEventsByTeam(sportsRepository: SportsRepository) = GetEventsByTeam(sportsRepository)

}