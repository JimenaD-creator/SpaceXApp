package com.example.spacexapp.data.remote

import com.example.spacexapp.data.remote.dto.LaunchDto
import retrofit2.http.GET

interface SpaceXApi {

    @GET()
    suspend fun getAllLaunches(): List<LaunchDto>

    companion object {
        const val BASE_URL = "https://api.spacexdata.com/"
    }
}