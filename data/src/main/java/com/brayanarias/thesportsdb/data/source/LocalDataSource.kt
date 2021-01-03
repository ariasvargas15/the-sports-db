package com.brayanarias.thesportsdb.data.source

import com.brayanarias.thesportsdb.domain.Event
import com.brayanarias.thesportsdb.domain.Team

interface LocalDataSource {
    suspend fun teamsIsEmpty(leagueName: String): Boolean
    suspend fun saveTeams(teams: List<Team>)
    suspend fun getTeams(leagueName: String): List<Team>
    suspend fun eventsIsEmpty(idTeam: String): Boolean
    suspend fun saveEvents(events: List<Event>)
    suspend fun getEvents(idTeam: String): List<Event>
}