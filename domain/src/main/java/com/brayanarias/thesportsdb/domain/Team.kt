package com.brayanarias.thesportsdb.domain

data class Team(
    val id: String,
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