package com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.R

@Composable
fun AboutScreen(
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7FAF7))
            .padding(20.dp)
    ) {
        Text(
            text = "Tentang Aplikasi",
            style = MaterialTheme.typography.headlineMedium,
            color = Color(0xFF2E7D32)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AboutCard(
            title = "Nama Aplikasi",
            desc = "EduCare"
        )

        AboutCard(
            title = "Tema",
            desc = "Edukasi Kesehatan Dasar"
        )

        AboutCard(
            title = "Sumber Data",
            desc = "GitHub Gist dengan Retrofit dan Gson"
        )

        AboutCard(
            title = "Identitas",
            desc = "M. Sultan Chaniago\nNPM 2457051003"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logout),
                    contentDescription = "Logout",
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(text = "Logout")
            }
        }
    }
}

@Composable
fun AboutCard(
    title: String,
    desc: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Text(text = desc)
        }
    }
}