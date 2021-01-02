package com.brayanarias.thesportsdb.data.repository

import com.brayanarias.thesportsdb.data.source.LocalDataSource
import com.brayanarias.thesportsdb.data.source.RemoteDataSource
import com.brayanarias.thesportsdb.domain.Event
import com.brayanarias.thesportsdb.domain.Team

class SportsRepository (
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val apiKey: String
        ){

    suspend fun getTeamsByLeague(nameLeague: String): List<Team> {
        if(localDataSource.teamsIsEmpty(nameLeague)) {
            val teams = remoteDataSource.getTeamsByLeague(nameLeague, apiKey)
            localDataSource.saveTeams(teams)
        }

        return localDataSource.getTeams(nameLeague)
    }

    suspend fun getEventsByTeam(idTeam: String): List<Event> {
        if (localDataSource.eventsIsEmpty(idTeam)) {
            val events = remoteDataSource.getNextEventsByTeam(idTeam, apiKey)
            localDataSource.saveEvents(events)
        }

        return localDataSource.getEvents(idTeam)
    }
}