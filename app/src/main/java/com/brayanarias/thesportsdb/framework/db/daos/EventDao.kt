package com.brayanarias.thesportsdb.framework.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.brayanarias.thesportsdb.framework.db.entities.Event

@Dao
interface EventDao {

    @Query("SELECT * FROM Event")
    fun getAll(): List<Event>

    @Query("SELECT * FROM Event WHERE idTeam = :idTeam")
    fun getAllByTeam(idTeam: String): List<Event>

    @Query("SELECT COUNT(id) FROM Event WHERE idTeam = :idTeam")
    fun countEventsByTeam(idTeam: String): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEvent(events: List<Event>)

}