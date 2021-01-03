package com.brayanarias.thesportsdb.framework.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.brayanarias.thesportsdb.framework.db.entities.Team

@Dao
interface TeamDao {

    @Query("SELECT * FROM Team")
    fun getAll(): List<Team>

    @Query("SELECT * FROM Team WHERE leagueName = :leagueName")
    fun getAllByLeague(leagueName: String): List<Team>

    @Query("SELECT COUNT(id) FROM Team WHERE leagueName = :leagueName")
    fun countTeamsByLeague(leagueName: String): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTeams(teams: List<Team>)
}