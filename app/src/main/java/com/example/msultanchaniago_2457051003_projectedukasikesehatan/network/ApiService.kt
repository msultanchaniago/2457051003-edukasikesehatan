package com.example.msultanchaniago_2457051003_projectedukasikesehatan.network

import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.Health
import retrofit2.http.GET

interface ApiService {

    @GET("health.json")
    suspend fun getHealth(): List<Health>
}