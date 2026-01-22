package com.example.spacexapp.di

import android.content.Context
import androidx.room.Room
import com.example.spacexapp.data.local.LaunchDao
import com.example.spacexapp.data.local.LaunchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule{
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): LaunchDatabase {
        return Room.databaseBuilder(
            context,
            LaunchDatabase::class.java,
            "spacex_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(database: LaunchDatabase): LaunchDao {
        return database.launchDao()
    }
}
