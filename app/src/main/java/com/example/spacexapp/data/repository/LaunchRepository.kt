package com.example.spacexapp.data.repository

import com.example.spacexapp.data.local.LaunchDao
import com.example.spacexapp.data.remote.SpaceXApi
import com.example.spacexapp.data.toDomain
import com.example.spacexapp.data.toEntity
import com.example.spacexapp.domain.Result
import com.example.spacexapp.domain.model.Launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LaunchRepository @Inject constructor(
    private val api: SpaceXApi,
    private val dao: LaunchDao
) {
    fun getLatestLaunches(forceRefresh: Boolean = false): Flow<Result<List<Launch>>> = flow {
        emit(Result.Loading)

        // First, emit cached data if available (for instant UI)
        val cachedLaunches = dao.getLatestLaunches().map { entities -> entities.map{it.toDomain()}}
        if(!forceRefresh) {
            cachedLaunches.collect { launches ->
                if(launches.isNotEmpty()){
                    emit(Result.Success(launches))
                }
            }

        }
        // Fetch data from API
        try {
            val launches = api.getAllLaunches()
                .sortedByDescending { it.dateUtc }
                .take(20)

            // Fetch rocket and launchpad details for each launch
            val enrichedEntities = launches.map { launchDto ->
                val rocket = api.getRocket(launchDto.rocketId)
                val launchpad = launchDto.launchpadId?.let {
                    api.getLaunchpad(it)
                }

                launchDto.toEntity(
                    rocketName = rocket.name,
                    rocketType = rocket.type,
                    launchSite = launchpad?.fullName ?: "Unknown"
                )
            }

            // Save to database
            dao.clearAll()
            dao.insertLaunches(enrichedEntities)

            // Emit fresh data
            emit(Result.Success(enrichedEntities.map { it.toDomain() }))

        } catch (e: Exception) {
            emit(Result.Error(e.message ?: "Unknown error occurred"))
        }
    }

    fun getLaunchById(launchId: String): Flow<Launch?>{
        return dao.getLaunchById(launchId).map { it?.toDomain() }
    }

}