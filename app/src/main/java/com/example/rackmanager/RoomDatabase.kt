package com.example.rackmanager

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RackEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun rackDao(): RackDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "rack_database"
                    ).build()
                }
                return INSTANCE as AppDatabase
            }
        }
    }
}
