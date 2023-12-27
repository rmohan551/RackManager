package com.example.rackmanager

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RackDao {
    @Insert
    suspend fun insert(rack: RackEntity)

    @Query("SELECT * FROM rack")
   fun getAllRacks(): LiveData<List<RackEntity>>
}
