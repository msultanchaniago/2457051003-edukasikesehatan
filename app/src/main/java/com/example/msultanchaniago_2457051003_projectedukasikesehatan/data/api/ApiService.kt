package com.example.msultanchaniago_2457051003_projectedukasikesehatan.data.api

import com.example.msultanchaniago_2457051003_projectedukasikesehatan.data.model.health
import retrofit2.http.GET

interface ApiService {

    @GET("health.json")
    suspend fun getHealth(): List<health>
}