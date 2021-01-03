package com.brayanarias.thesportsdb.framework.db.daos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.brayanarias.thesportsdb.framework.db.SportsDatabaseTest
import com.brayanarias.thesportsdb.framework.db.entities.Team
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class TeamDaoTest : SportsDatabaseTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val team = Team(
        id = "12345",
        name = "Barcelona",
        stadium = "Camp Nou",
        badge = "",
        description = "Description",
        foundationYear = "1989",
        jersey = "",
        website = "",
        facebook = "",
        instagram = "",
        twitter = "",
        youtube = "",
        leagueName = "Spanish la Liga"
    )
    private val existentLeagueName = "Spanish la Liga"
    private val fakeLeagueName = "another league"


    @Test
    fun insertTeamsTest() {
        val list = ArrayList<Team>()
        list.add(team)
        appDatabase.teamDao().insertTeams(list)
        val teamsSize = appDatabase.teamDao().getAll().size
        assertEquals(teamsSize, 1)
    }

    @Test
    fun insertDuplicateTeamTest() {
        val list = ArrayList<Team>()
        list.add(team)
        list.add(team)
        list.add(team)
        appDatabase.teamDao().insertTeams(list)
        val teamsSize = appDatabase.teamDao().getAll().size
        assertEquals(teamsSize, 1)
    }

    @Test
    fun getAllTest() {
        val list = ArrayList<Team>()
        list.add(team)
        appDatabase.teamDao().insertTeams(list)
        val teamValue = appDatabase.teamDao().getAll()
        assertEquals(teamValue.size, 1)
    }

    @Test
    fun getAllByLeagueTest() {
        val list = ArrayList<Team>()
        list.add(team)
        appDatabase.teamDao().insertTeams(list)
        val teamValue = appDatabase.teamDao().getAllByLeague(existentLeagueName)
        assertEquals(teamValue.size, 1)
    }

    @Test
    fun getAllByLeagueEmptyTest() {
        val list = ArrayList<Team>()
        list.add(team)
        appDatabase.teamDao().insertTeams(list)
        val teamValue = appDatabase.teamDao().getAllByLeague(fakeLeagueName)
        assertEquals(teamValue.size, 0)
    }

    @Test
    fun countEventsByTeamTest() {
        val team2 = Team(
            id = "12346",
            name = "Real Madrid",
            stadium = "Santiago Bernabeu",
            badge = "",
            description = "Description",
            foundationYear = "1989",
            jersey = "",
            website = "",
            facebook = "",
            instagram = "",
            twitter = "",
            youtube = "",
            leagueName = "Spanish la Liga"
        )
        val list = ArrayList<Team>()
        list.add(team)
        list.add(team2)
        appDatabase.teamDao().insertTeams(list)
        val teamValue = appDatabase.teamDao().countTeamsByLeague(existentLeagueName)
        assertEquals(teamValue, 2)
    }

    @Test
    fun countEmptyEventsByTeamTest() {
        val list = ArrayList<Team>()
        list.add(team)
        appDatabase.teamDao().insertTeams(list)
        val teamValue = appDatabase.teamDao().countTeamsByLeague(fakeLeagueName)
        assertEquals(teamValue, 0)
    }


}