package com.brayanarias.thesportsdb.framework.network

import com.brayanarias.thesportsdb.domain.League
import com.brayanarias.thesportsdb.framework.network.results.EventResult
import com.brayanarias.thesportsdb.framework.network.results.TeamResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("{apiKey}/search_all_teams.php")
    suspend fun listTeamsByLeagueAsync(
        @Path("apiKey") apiKey: String,
        @Query("l") league: String
    ): TeamResult

    @GET("{apiKey}/eventsnext.php")
    suspend fun listNextEventsByTeam(
        @Path("apiKey") apiKey: String,
        @Query("id") idTeam: String
    ): EventResult
}