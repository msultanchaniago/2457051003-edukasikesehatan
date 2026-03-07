package com.example.msultanchaniago_2457051003_projectedukasikesehatan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.Health
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.HealthRepository

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DaftarHealthScreen()
        }
    }
}

@Composable
fun DaftarHealthScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp)
    ) {

        HealthRepository.healthList.forEach { item ->

            DetailHealthScreen(item)

            Spacer(modifier = Modifier.height(24.dp))

        }
    }
}

@Composable
fun DetailHealthScreen(health: Health) {

    Column(modifier = Modifier.fillMaxWidth()) {

        Image(
            painter = painterResource(id = health.imageRes),
            contentDescription = health.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = health.title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = health.description)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Manfaat: ${health.benefit}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Pelajari Sekarang")
        }
    }
}