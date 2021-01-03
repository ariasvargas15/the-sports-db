package com.brayanarias.thesportsdb.usecases

import com.brayanarias.thesportsdb.GetEventsByTeam
import com.brayanarias.thesportsdb.data.repository.SportsRepository
import com.brayanarias.thesportsdb.domain.Event
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class GetEventsByTeamTest {

    @Mock
    private lateinit var sportsRepository: SportsRepository

    @InjectMocks
    private lateinit var getEventsByTeam: GetEventsByTeam

    @Test
    fun invokeTest() = runBlocking {
        val idTeam = "12345"
        val list = ArrayList<Event>()
        val event = mock(Event::class.java)
        list.add(event)

        `when`(sportsRepository.getEventsByTeam(idTeam)).thenReturn(list)

        val list2 = getEventsByTeam.invoke(idTeam)

        Assert.assertNotNull(list2)
        Assert.assertEquals(list.size, list.size)
        Assert.assertNotEquals(list.size, 3)
        Assert.assertEquals(list.size, 1)
        Assert.assertEquals(list[0], list2[0])

    }
}