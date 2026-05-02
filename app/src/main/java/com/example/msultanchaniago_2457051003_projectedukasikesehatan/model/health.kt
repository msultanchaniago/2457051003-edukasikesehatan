package com.example.msultanchaniago_2457051003_projectedukasikesehatan.model

import com.google.gson.annotations.SerializedName

data class Health(
    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("benefit")
    val benefit: String,

    @SerializedName("image_url")
    val imageUrl: String
)