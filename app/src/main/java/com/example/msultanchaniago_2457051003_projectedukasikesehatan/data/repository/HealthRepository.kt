package com.example.msultanchaniago_2457051003_projectedukasikesehatan.data.repository

import com.example.msultanchaniago_2457051003_projectedukasikesehatan.data.api.RetrofitClient
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.data.model.health

class HealthRepository {

    suspend fun getHealth(): List<health> {
        return RetrofitClient.instance.getHealth()
    }
}