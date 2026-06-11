package com.example.msultanchaniago_2457051003_projectedukasikesehatan.data.api

import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.Health
import retrofit2.http.GET

interface ApiService {

    @GET("msultanchaniago/b1175e8024af87e1a3b716c7bb707586/raw/da553356e75f1bcb119f4d965da6127807b6812e/edukasi_kesehatan.json")
    suspend fun getHealthData(): List<Health>
}