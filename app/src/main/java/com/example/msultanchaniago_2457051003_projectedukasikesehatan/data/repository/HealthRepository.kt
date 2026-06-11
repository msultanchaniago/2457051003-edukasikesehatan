package com.example.msultanchaniago_2457051003_projectedukasikesehatan.repository

import com.example.msultanchaniago_2457051003_projectedukasikesehatan.data.api.RetroFitClient
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.Health

object HealthRepository {

    suspend fun getHealthList(): List<Health> {
        return RetroFitClient.apiService.getHealthData()
    }
}