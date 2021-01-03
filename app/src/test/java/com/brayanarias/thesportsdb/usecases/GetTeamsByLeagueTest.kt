package com.brayanarias.thesportsdb.usecases

import com.brayanarias.thesportsdb.GetEventsByTeam
import com.brayanarias.thesportsdb.GetTeamsByLeague
import com.brayanarias.thesportsdb.data.repository.SportsRepository
import com.brayanarias.thesportsdb.domain.Event
import com.brayanarias.thesportsdb.domain.Team
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class GetTeamsByLeagueTest {

    @Mock
    private lateinit var sportsRepository: SportsRepository

    @InjectMocks
    private lateinit var getTeamsByLeague: GetTeamsByLeague

    @Test
    fun invokeTest() = runBlocking {
        val leagueName = "12345"
        val list = ArrayList<Team>()
        val team = Mockito.mock(Team::class.java)
        list.add(team)

        `when`(sportsRepository.getTeamsByLeague(leagueName)).thenReturn(list)

        val list2 = getTeamsByLeague.invoke(leagueName)

        Assert.assertNotNull(list2)
        Assert.assertEquals(list.size, list.size)
        Assert.assertNotEquals(list.size, 3)
        Assert.assertEquals(list.size, 1)
        Assert.assertEquals(list[0], list2[0])

    }
}