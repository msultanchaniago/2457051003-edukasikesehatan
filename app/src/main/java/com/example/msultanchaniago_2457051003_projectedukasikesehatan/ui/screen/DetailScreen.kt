package com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.Health

@Composable
fun DetailScreen(
    health: Health,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val imageId = context.resources.getIdentifier(
        health.image,
        "drawable",
        context.packageName
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7FAF7))
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Button(onClick = onBack) {
            Text(text = "Kembali")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (imageId != 0) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = health.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(24.dp))
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = health.title,
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2E7D32)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = getHealthIcon(health.image)),
                contentDescription = health.category,
                modifier = Modifier.size(20.dp),
                tint = Color(0xFF2E7D32)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Kategori: ${health.category}",
                color = Color(0xFF2E7D32)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        DetailInfoCard(
            title = "Deskripsi",
            content = health.description
        )

        Spacer(modifier = Modifier.height(12.dp))

        DetailInfoCard(
            title = "Manfaat",
            content = health.benefit
        )
    }
}

@Composable
fun DetailInfoCard(
    title: String,
    content: String
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(text = content)
        }
    }
}