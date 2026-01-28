package com.example.spacexapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "launches")

data class LaunchEntity (
    @PrimaryKey val id: String,
    val flightNumber: Int,
    val missionName: String,
    val rocketName: String,
    val rocketType: String,
    val launchSite: String,
    val details: String?,
    val launchDateUtc: String
)