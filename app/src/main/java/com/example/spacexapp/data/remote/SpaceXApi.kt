package com.example.spacexapp.data.remote

import com.example.spacexapp.data.remote.dto.LaunchDto
import com.example.spacexapp.data.remote.dto.LaunchpadDto
import com.example.spacexapp.data.remote.dto.RocketDto
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXApi {

    @GET("v4/launches")
    suspend fun getAllLaunches(): List<LaunchDto>

    @GET("v4/rockets/{id}")
    suspend fun getRocket(
        @Path("id") rocketId: String
    ): RocketDto

    @GET("v4/launchpads/{id}")
    suspend fun getLaunchpad(
        @Path("id") launchpadId: String
    ): LaunchpadDto

    companion object {
        const val BASE_URL = "https://api.spacexdata.com/"
    }
}