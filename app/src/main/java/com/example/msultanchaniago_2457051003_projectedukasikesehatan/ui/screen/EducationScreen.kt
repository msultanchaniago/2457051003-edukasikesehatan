package com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.R
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.Health
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.repository.HealthRepository

@Composable
fun EducationScreen(
    onItemClick: (Health) -> Unit
) {
    val healthList = remember { mutableStateListOf<Health>() }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf("") }
    var reloadKey by remember { mutableStateOf(0) }

    LaunchedEffect(reloadKey) {
        try {
            isLoading = true
            errorMessage = ""

            val data = HealthRepository.getHealthList()

            healthList.clear()
            healthList.addAll(data)

            isLoading = false
        } catch (e: Exception) {
            errorMessage = "Gagal memuat data dari Gist"
            isLoading = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7FAF7))
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Edukasi Kesehatan",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF2E7D32)
            )

            Text(text = "Pilih materi untuk melihat detail edukasi.")
        }

        when {
            isLoading -> {
                Text(
                    text = "Memuat data...",
                    modifier = Modifier.padding(20.dp)
                )
            }

            errorMessage.isNotEmpty() -> {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(text = errorMessage)

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            reloadKey++
                        }
                    ) {
                        Text(text = "Coba Lagi")
                    }
                }
            }

            else -> {
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 20.dp,
                        end = 20.dp,
                        bottom = 20.dp
                    )
                ) {
                    items(healthList) { health ->
                        HealthCard(
                            health = health,
                            onClick = {
                                onItemClick(health)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HealthCard(
    health: Health,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    val imageId = context.resources.getIdentifier(
        health.image,
        "drawable",
        context.packageName
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable {
                onClick()
            },
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (imageId != 0) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = health.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column {
                Text(
                    text = health.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = getHealthIcon(health.image)),
                        contentDescription = health.category,
                        modifier = Modifier.size(18.dp),
                        tint = Color(0xFF2E7D32)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = health.category,
                        color = Color(0xFF2E7D32)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text(text = health.description)
            }
        }
    }
}

@DrawableRes
fun getHealthIcon(imageName: String): Int {
    return when (imageName) {
        "cucitangan" -> R.drawable.ic_hand_wash
        "makanansehat" -> R.drawable.ic_food
        "minum" -> R.drawable.ic_water
        "olahraga" -> R.drawable.ic_exercise
        "tidurcukup" -> R.drawable.ic_sleep
        else -> R.drawable.ic_health
    }
}