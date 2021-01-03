package com.brayanarias.thesportsdb.framework.network

import com.brayanarias.thesportsdb.data.source.RemoteDataSource
import com.brayanarias.thesportsdb.domain.Event
import com.brayanarias.thesportsdb.domain.Team
import com.brayanarias.thesportsdb.framework.utils.RemoteToDomainTeam
import com.brayanarias.thesportsdb.framework.utils.datamappers.RemoteToDomainEvent

class SportsRemoteDataSource : RemoteDataSource {

    override suspend fun getTeamsByLeague(leagueName: String, apiKey: String): List<Team> =
        ApiAdapter.service
            .listTeamsByLeagueAsync(apiKey, leagueName)
            .teams
            .map {
                it.RemoteToDomainTeam(leagueName)
            }


    override suspend fun getNextEventsByTeam(idTeam: String, apiKey: String): List<Event> =
        ApiAdapter.service
            .listNextEventsByTeam(apiKey, idTeam)
            .events
            .map {
                it.RemoteToDomainEvent(idTeam)
            }

}