package com.example.rackmanager

import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST



interface ApiService {

    // Get all racks
    @GET("/rack")
    fun getAllRacks(): Call<List<RackEntity>>

    // Get rack by ID
    @GET("/rack/{id}")
    fun getRackById(@Path("id") id: String): Call<RackEntity>

    // Create a new rack
    @POST("/rack")
    suspend fun createRack(@Body rack:RackEntity): RackEntity

    // Update an existing rack
    @PUT("/rack/{id}")
    fun updateRack(@Path("id") id: String, @Body updatedRack: RackEntity): Call<RackEntity>

    // Delete a rack
    @DELETE("/rack/{id}")
    fun deleteRack(@Path("id") id: String): Call<Void>


}



