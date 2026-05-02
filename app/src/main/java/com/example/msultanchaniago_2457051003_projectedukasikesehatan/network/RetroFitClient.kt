package com.example.msultanchaniago_2457051003_projectedukasikesehatan.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL =
        "https://gist.githubusercontent.com/msultanchaniago/98ca12e164857a181d41b6e029cf4dac/raw/28749179245ae280b140ad85729f387d3f63f830/"

    val instance: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}