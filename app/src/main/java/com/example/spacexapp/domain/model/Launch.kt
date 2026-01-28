package com.example.spacexapp.domain.model

data class Launch (
    val id: String,
    val flightNumber: Int,
    val missionName: String,
    val rocketName: String,
    val rocketType: String,
    val launchSite: String,
    val details: String?,
    val launchDateUtc: String,
)
