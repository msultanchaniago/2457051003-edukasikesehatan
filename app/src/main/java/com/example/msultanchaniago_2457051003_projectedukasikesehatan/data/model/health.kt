package com.example.msultanchaniago_2457051003_projectedukasikesehatan.data.model

import com.google.gson.annotations.SerializedName

data class health(
    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("benefit")
    val benefit: String,

    @SerializedName("image_url")
    val imageUrl: String
)