package com.example.spacexapp.data

import com.example.spacexapp.data.local.entity.LaunchEntity
import com.example.spacexapp.data.remote.dto.LaunchDto
import com.example.spacexapp.domain.model.Launch

// DTO (from API) to Entity (for database)
fun LaunchDto.toEntity(rocketName: String, rocketType: String, launchSite: String): LaunchEntity {
    return LaunchEntity(
        id = id,
        flightNumber = flightNumber,
        missionName = missionName,
        rocketName = rocketName,
        rocketType = rocketType,
        launchSite = launchSite,
        details = details,
        launchDateUtc = dateUtc
    )
}

// Entity (from database) to Domain (for UI)
fun LaunchEntity.toDomain(): Launch{
    return Launch(
        id = id,
        flightNumber = flightNumber,
        missionName = missionName,
        rocketName = rocketName,
        rocketType = rocketType,
        launchSite = launchSite,
        details = details,
        launchDateUtc = launchDateUtc,
    )
}