package com.brayanarias.thesportsdb.framework.network.results

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

data class EventResult(
    val events: List<Event>
)

@Parcelize
data class Event(
    @SerializedName("idEvent") val id: String,
    @SerializedName("strEvent") val name: String,
    @SerializedName("strTimestamp") val date: String,
) : Parcelable