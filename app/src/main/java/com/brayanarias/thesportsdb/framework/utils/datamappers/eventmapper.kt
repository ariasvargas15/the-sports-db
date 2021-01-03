package com.brayanarias.thesportsdb.framework.utils.datamappers

import com.brayanarias.thesportsdb.framework.network.results.Event as RemoteEvent
import com.brayanarias.thesportsdb.framework.db.entities.Event as RoomEvent
import com.brayanarias.thesportsdb.domain.Event as DomainEvent

fun DomainEvent.DomainToRoomEvent(): RoomEvent =
    RoomEvent(
        id,
        name,
        date,
        idTeam,
    )

fun RoomEvent.RoomToDomainEvent(): DomainEvent =
    DomainEvent(
        id,
        name,
        date,
        idTeam,
    )

fun RemoteEvent.RemoteToDomainEvent(idTeam: String): DomainEvent =
    DomainEvent(
        id,
        name,
        date,
        idTeam,
    )