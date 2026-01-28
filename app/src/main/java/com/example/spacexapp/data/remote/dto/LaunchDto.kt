package com.example.spacexapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable

data class LaunchDto (
    @SerialName("id") val id: String,
    @SerialName("flight_number") val flightNumber: Int,
    @SerialName("name") val missionName: String,
    @SerialName("rocket") val rocketId: String,
    @SerialName("launchpad") val launchpadId: String?,
    @SerialName("details") val details: String?,
    @SerialName("date_utc") val dateUtc: String
)