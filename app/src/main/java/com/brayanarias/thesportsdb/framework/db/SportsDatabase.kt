package com.brayanarias.thesportsdb.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brayanarias.thesportsdb.framework.db.daos.EventDao
import com.brayanarias.thesportsdb.framework.db.daos.TeamDao
import com.brayanarias.thesportsdb.framework.db.entities.Event
import com.brayanarias.thesportsdb.framework.db.entities.Team

@Database(entities = [Event::class, Team::class], version = 1, exportSchema = false)
abstract class SportsDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
    abstract fun eventDao(): EventDao
}