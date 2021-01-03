package com.brayanarias.thesportsdb.framework.utils

import com.brayanarias.thesportsdb.framework.network.results.Team as RemoteTeam
import com.brayanarias.thesportsdb.framework.db.entities.Team as RoomTeam
import com.brayanarias.thesportsdb.domain.Team as DomainTeam

fun DomainTeam.DomainToRoomTeam(): RoomTeam =
    RoomTeam(
        id,
        name,
        stadium,
        badge,
        description,
        foundationYear,
        jersey,
        website,
        facebook,
        instagram,
        twitter,
        youtube,
        leagueName
    )

fun RoomTeam.RoomToDomainTeam(): DomainTeam =
    DomainTeam(
        id,
        name,
        stadium,
        badge,
        description,
        foundationYear,
        jersey,
        website,
        facebook,
        instagram,
        twitter,
        youtube,
        leagueName
    )

fun RemoteTeam.RemoteToDomainTeam(leagueName: String): DomainTeam =
    DomainTeam(
        id,
        name,
        stadium,
        badge,
        description,
        foundationYear,
        jersey ?: "",
        website,
        facebook,
        instagram,
        twitter,
        youtube,
        leagueName
    )