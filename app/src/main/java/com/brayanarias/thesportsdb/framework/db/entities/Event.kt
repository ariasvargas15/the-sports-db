package com.brayanarias.thesportsdb.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Event(
    @PrimaryKey val id: String,
    val name: String,
    val date: String,
    val idTeam: String
)