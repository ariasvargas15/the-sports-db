package com.brayanarias.thesportsdb.framework.db.daos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.brayanarias.thesportsdb.framework.db.SportsDatabaseTest
import com.brayanarias.thesportsdb.framework.db.entities.Event
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class EventDaoTest : SportsDatabaseTest() {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val event = Event(
        id = "12345",
        name = "Barcelona vs Real Madrid",
        date = "27/12/1998",
        idTeam = "123"
    )
    private val existentIdTeam = "123"
    private val fakeIdTeam = "999"


    @Test
    fun insertEventTest() {
        val list = ArrayList<Event>()
        list.add(event)
        appDatabase.eventDao().insertEvent(list)
        val eventSize = appDatabase.eventDao().getAll().size
        assertEquals(eventSize, 1)
    }

    @Test
    fun insertDuplicateEventTest() {
        val list = ArrayList<Event>()
        list.add(event)
        list.add(event)
        appDatabase.eventDao().insertEvent(list)
        val eventSize = appDatabase.eventDao().getAll().size
        assertEquals(eventSize, 1)
    }

    @Test
    fun getAllTest() {
        val list = ArrayList<Event>()
        list.add(event)
        appDatabase.eventDao().insertEvent(list)
        val eventValue = appDatabase.eventDao().getAll()
        assertEquals(eventValue.size, 1)
    }

    @Test
    fun getAllByTeamTest() {
        val list = ArrayList<Event>()
        list.add(event)
        appDatabase.eventDao().insertEvent(list)
        val eventValue = appDatabase.eventDao().getAllByTeam(existentIdTeam)
        assertEquals(eventValue.size, 1)
    }

    @Test
    fun getAllByTeamEmptyTest() {
        val list = ArrayList<Event>()
        list.add(event)
        appDatabase.eventDao().insertEvent(list)
        val eventValue = appDatabase.eventDao().getAllByTeam(fakeIdTeam)
        assertEquals(eventValue.size, 0)
    }

    @Test
    fun countEventsByTeamTest() {
        val event2 = Event(
            id = "12346",
            name = "Atletico Madrid vs Barcelona",
            date = "27/12/1998",
            idTeam = "123"
        )
        val list = ArrayList<Event>()
        list.add(event)
        list.add(event2)
        appDatabase.eventDao().insertEvent(list)
        val eventValue = appDatabase.eventDao().countEventsByTeam(existentIdTeam)
        assertEquals(eventValue, 2)
    }

    @Test
    fun countEmptyEventsByTeamTest() {
        val list = ArrayList<Event>()
        list.add(event)
        appDatabase.eventDao().insertEvent(list)
        val eventValue = appDatabase.eventDao().countEventsByTeam(fakeIdTeam)
        assertEquals(eventValue, 0)
    }


}