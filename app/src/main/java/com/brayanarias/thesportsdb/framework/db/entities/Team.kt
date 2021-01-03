package com.brayanarias.thesportsdb.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Team(
    @PrimaryKey val id: String,
    val name: String,
    val stadium: String,
    val badge: String,
    val description: String,
    val foundationYear: String,
    val jersey: String,
    val website: String,
    val facebook: String,
    val instagram: String,
    val twitter: String,
    val youtube: String,
    val leagueName: String
)