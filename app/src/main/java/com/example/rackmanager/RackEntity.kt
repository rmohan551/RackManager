package com.example.rackmanager


import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
@Entity(tableName = "rack")
data class RackEntity(

    @Json(name = "name")
    val name: String?

)
