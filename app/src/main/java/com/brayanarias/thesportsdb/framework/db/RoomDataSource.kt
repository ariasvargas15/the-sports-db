package com.brayanarias.thesportsdb.framework.db

import com.brayanarias.thesportsdb.data.source.LocalDataSource
import com.brayanarias.thesportsdb.domain.Event
import com.brayanarias.thesportsdb.domain.Team
import com.brayanarias.thesportsdb.framework.utils.*
import com.brayanarias.thesportsdb.framework.utils.datamappers.DomainToRoomEvent
import com.brayanarias.thesportsdb.framework.utils.datamappers.RoomToDomainEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: SportsDatabase) : LocalDataSource {

    private val teamDao = db.teamDao()
    private val eventDao = db.eventDao()

    override suspend fun teamsIsEmpty(leagueName: String): Boolean =
        withContext(Dispatchers.IO) { teamDao.countTeamsByLeague(leagueName) <= 0 }


    override suspend fun saveTeams(teams: List<Team>) {
        withContext(Dispatchers.IO) { teamDao.insertTeams(teams.map { it.DomainToRoomTeam() }) }
    }

    override suspend fun getTeams(leagueName: String): List<Team> =
        withContext(Dispatchers.IO) {
            teamDao.getAllByLeague(leagueName).map { it.RoomToDomainTeam() }
        }


    override suspend fun eventsIsEmpty(idTeam: String): Boolean =
        withContext(Dispatchers.IO) { eventDao.countEventsByTeam(idTeam) <= 0 }


    override suspend fun saveEvents(events: List<Event>) {
        withContext(Dispatchers.IO) { eventDao.insertEvent(events.map { it.DomainToRoomEvent() }) }
    }

    override suspend fun getEvents(idTeam: String): List<Event> =
        withContext(Dispatchers.IO) {
            eventDao.getAllByTeam(idTeam).map { it.RoomToDomainEvent() }
        }

}