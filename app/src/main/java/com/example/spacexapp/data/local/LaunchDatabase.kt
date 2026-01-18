package com.example.spacexapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.spacexapp.data.local.entity.LaunchEntity

@Database(
    entities = [LaunchEntity::class],
    version = 1,
    exportSchema = false
)
abstract class LaunchDatabase: RoomDatabase(){
    abstract fun launchDao(): LaunchDao
}




