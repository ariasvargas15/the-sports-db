package com.brayanarias.thesportsdb.domain

import java.util.*

data class Event(
    val id: String,
    val name: String,
    val date: String,
    val idTeam: String
)