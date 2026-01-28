package com.example.spacexapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LaunchpadDto (
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("full_name") val fullName: String

)