package com.example.spacexapp.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketDto (
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("type") val type: String

)