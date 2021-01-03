package com.brayanarias.thesportsdb.repository

import com.brayanarias.thesportsdb.data.repository.SportsRepository
import com.brayanarias.thesportsdb.data.source.ApiKeyDataSource
import com.brayanarias.thesportsdb.data.source.LocalDataSource
import com.brayanarias.thesportsdb.data.source.RemoteDataSource
import com.brayanarias.thesportsdb.domain.Event
import com.brayanarias.thesportsdb.domain.Team
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class SportsRepositoryTest {

    @Mock
    private lateinit var localDataSource: LocalDataSource

    @Mock
    private lateinit var remoteDataSource: RemoteDataSource

    @Mock
    private lateinit var apiKey: ApiKeyDataSource

    @InjectMocks
    private lateinit var sportsRepository: SportsRepository

    @Test
    fun getTeamsByLeagueLocalNotEmpty() = runBlocking {
        val leagueName = "12345"
        val isEmpty = false
        val team = mock(Team::class.java)

        val remoteTeams = ArrayList<Team>()
        remoteTeams.add(team)

        val localTeams = ArrayList<Team>()
        localTeams.add(team)

        `when`(localDataSource.teamsIsEmpty(leagueName)).thenReturn(isEmpty)
        `when`(localDataSource.getTeams(leagueName)).thenReturn(localTeams)

        val listReturn = sportsRepository.getTeamsByLeague(leagueName)

        Assert.assertNotNull(listReturn)
        Assert.assertNotEquals(listReturn, 0)
        Assert.assertEquals(listReturn[0], team)

        verify(localDataSource, times(0)).saveTeams(localTeams)

    }

    @Test
    fun getTeamsByLeagueLocalEmpty() = runBlocking {
        val leagueName = "12345"
        val isEmpty = true
        val team = mock(Team::class.java)

        val remoteTeams = ArrayList<Team>()
        remoteTeams.add(team)

        val localTeams = ArrayList<Team>()
        localTeams.add(team)

        `when`(localDataSource.teamsIsEmpty(leagueName)).thenReturn(isEmpty)
        `when`(remoteDataSource.getTeamsByLeague(leagueName, apiKey.getApiKey())).thenReturn(remoteTeams)
        `when`(localDataSource.getTeams(leagueName)).thenReturn(localTeams)

        val listReturn = sportsRepository.getTeamsByLeague(leagueName)

        Assert.assertNotNull(listReturn)
        Assert.assertNotEquals(listReturn, 0)
        Assert.assertEquals(listReturn[0], team)

        verify(localDataSource, times(1)).saveTeams(remoteTeams)

    }

    @Test
    fun getEventsByTeamLocalNotEmpty() = runBlocking {
        val idTeam = "12345"
        val isEmpty = false
        val event = mock(Event::class.java)

        val remoteEvents = ArrayList<Event>()
        remoteEvents.add(event)

        val localEvent = ArrayList<Event>()
        localEvent.add(event)

        `when`(localDataSource.eventsIsEmpty(idTeam)).thenReturn(isEmpty)
        `when`(localDataSource.getEvents(idTeam)).thenReturn(localEvent)

        val listReturn = sportsRepository.getEventsByTeam(idTeam)

        Assert.assertNotNull(listReturn)
        Assert.assertNotEquals(listReturn, 0)
        Assert.assertEquals(listReturn[0], event)

        verify(localDataSource, times(0)).saveEvents(localEvent)

    }

    @Test
    fun getEventsByTeamLocalEmpty() = runBlocking {
        val idTeam = "12345"
        val isEmpty = true
        val event = mock(Event::class.java)

        val remoteEvents = ArrayList<Event>()
        remoteEvents.add(event)

        val localEvent = ArrayList<Event>()
        localEvent.add(event)

        `when`(localDataSource.eventsIsEmpty(idTeam)).thenReturn(isEmpty)
        `when`(remoteDataSource.getNextEventsByTeam(idTeam, apiKey.getApiKey())).thenReturn(remoteEvents)
        `when`(localDataSource.getEvents(idTeam)).thenReturn(localEvent)

        val listReturn = sportsRepository.getEventsByTeam(idTeam)

        Assert.assertNotNull(listReturn)
        Assert.assertNotEquals(listReturn, 0)
        Assert.assertEquals(listReturn[0], event)

        verify(localDataSource, times(1)).saveEvents(remoteEvents)

    }


}