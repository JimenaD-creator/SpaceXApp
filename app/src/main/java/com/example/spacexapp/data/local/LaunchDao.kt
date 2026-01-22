package com.example.spacexapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.spacexapp.data.local.entity.LaunchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LaunchDao {

    @Query("SELECT * FROM launches ORDER BY launchDateUtc DESC LIMIT 20")
    fun getLatestLaunches(): Flow<List<LaunchEntity>>

    @Query("SELECT * FROM launches WHERE id = :launchId")
    fun getLaunchById(launchId: String): Flow<LaunchEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLaunches(launches: List<LaunchEntity>)

    @Query("DELETE FROM launches")
    suspend fun clearAll()
}