package com.brayanarias.thesportsdb

import com.brayanarias.thesportsdb.data.repository.SportsRepository
import com.brayanarias.thesportsdb.domain.Event

class GetEventsByTeam (private val sportsRepository: SportsRepository) {
    suspend fun invoke(idTeam: String): List<Event> = sportsRepository.getEventsByTeam(idTeam)
}