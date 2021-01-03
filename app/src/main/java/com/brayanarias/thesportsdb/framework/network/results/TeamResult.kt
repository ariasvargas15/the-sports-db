package com.brayanarias.thesportsdb.framework.network.results

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import javax.annotation.Nullable

data class TeamResult(
    val teams: List<Team>
)

@Parcelize
data class Team(
    @SerializedName("idTeam") val id: String,
    @SerializedName("strTeam") val name: String,
    @SerializedName("strStadium") val stadium: String,
    @SerializedName("strTeamBadge") val badge: String,
    @SerializedName("strDescriptionEN") val description: String,
    @SerializedName("intFormedYear") val foundationYear: String,
    @Nullable @SerializedName("strTeamJersey") val jersey: String,
    @SerializedName("strWebsite") val website: String,
    @SerializedName("strFacebook") val facebook: String,
    @SerializedName("strInstagram") val instagram: String,
    @SerializedName("strTwitter") val twitter: String,
    @SerializedName("strYoutube") val youtube: String,
) : Parcelable