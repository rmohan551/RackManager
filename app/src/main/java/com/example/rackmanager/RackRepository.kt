package com.example.rackmanager

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RackRepository(private val apiService: ApiService) {

    private suspend fun <T> Call<T>.apiCall(): T? {
        return withContext(Dispatchers.IO) {
            runCatching {
                execute()
            }.onSuccess { response ->
                if (response.isSuccessful) {
                    return@withContext response.body()
                }
            }.onFailure { e ->
                e.printStackTrace()
                throw e
            }
            return@withContext null
        }
    }

    suspend fun getRacks(): List<RackEntity> {
        return apiService.getAllRacks().apiCall() ?: emptyList()
    }

    suspend fun createRack(newRack: RackEntity): RackEntity {
        return withContext(Dispatchers.IO) {apiService.createRack(newRack)}
    }
}
