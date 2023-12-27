package com.example.rackmanager

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date


@JsonClass(generateAdapter = true)
@Entity(tableName = "rack")
data class RackEntity(

    @Json(name = "name")
    val name: String,

)
