package com.brayanarias.thesportsdb.data.source

import com.brayanarias.thesportsdb.domain.Event
import com.brayanarias.thesportsdb.domain.Team


interface RemoteDataSource {
    suspend fun getTeamsByLeague(leagueName: String, apiKey: String): List<Team>
    suspend fun getNextEventsByTeam(idTeam: String, apiKey: String): List<Event>
}