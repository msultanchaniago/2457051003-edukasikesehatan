package com.example.msultanchaniago_2457051003_projectedukasikesehatan.model

import com.example.msultanchaniago_2457051003_projectedukasikesehatan.R

object HealthRepository {

    val healthList = listOf(
        Health(
            "Cuci Tangan",
            "Mencuci tangan dengan sabun sebelum makan",
            "Mencegah kuman dan penyakit",
            R.drawable.cucitangan
        ),
        Health(
            "Makan Sehat",
            "Konsumsi sayur dan buah setiap hari",
            "Menjaga daya tahan tubuh",
            R.drawable.makanansehat
        ),
        Health(
            "Minum Air",
            "Minum 8 gelas air setiap hari",
            "Mencegah dehidrasi",
            R.drawable.minum
        )
    )
}