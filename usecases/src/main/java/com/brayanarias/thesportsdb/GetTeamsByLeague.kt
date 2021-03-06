package com.brayanarias.thesportsdb

import com.brayanarias.thesportsdb.data.repository.SportsRepository
import com.brayanarias.thesportsdb.domain.Team

class GetTeamsByLeague (private val sportsRepository: SportsRepository) {
    suspend fun invoke(leagueName: String): List<Team> = sportsRepository.getTeamsByLeague(leagueName)
}