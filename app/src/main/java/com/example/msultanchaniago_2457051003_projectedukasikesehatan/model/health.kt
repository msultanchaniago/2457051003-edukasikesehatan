package com.example.msultanchaniago_2457051003_projectedukasikesehatan.model

import androidx.annotation.DrawableRes

data class Health(
    val title: String,
    val description: String,
    val benefit: String,
    @DrawableRes val imageRes: Int
)