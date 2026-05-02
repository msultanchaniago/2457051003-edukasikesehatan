package com.example.msultanchaniago_2457051003_projectedukasikesehatan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder

import androidx.compose.material3.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import coil.compose.AsyncImage
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.Health
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.network.RetrofitClient
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.theme.ProjectEdukasiKesehatanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProjectEdukasiKesehatanTheme {
                DaftarHealthScreen()
            }
        }
    }
}

@Composable
fun DaftarHealthScreen() {

    var healthList by remember { mutableStateOf<List<Health>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            healthList = RetrofitClient.instance.getHealth()
        } catch (e: Exception) {
            e.printStackTrace()
            isError = true
        }
        isLoading = false
    }

    when {
        isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        isError -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Gagal memuat data")
            }
        }

        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentPadding = PaddingValues(16.dp)
            ) {

                // 🔥 HEADER 1
                item {
                    Text(
                        text = "Rekomendasi Populer",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                }

                // 🔥 LAZY ROW
                item {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(healthList) { item ->
                            HealthRowItem(item)
                        }
                    }
                }

                // 🔥 HEADER 2
                item {
                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Daftar Menu Lengkap",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                }

                // 🔥 LIST VERTICAL
                items(healthList) { item ->
                    DetailHealthScreen(item)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun HealthRowItem(health: Health) {

    Card(
        modifier = Modifier.width(160.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {

            AsyncImage(
                model = health.imageUrl,
                contentDescription = health.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = health.title,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = health.benefit,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun DetailHealthScreen(health: Health) {

    var isFavorite by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Box(modifier = Modifier.fillMaxWidth()) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {

            Column(modifier = Modifier.padding(12.dp)) {

                Box {

                    AsyncImage(
                        model = health.imageUrl,
                        contentDescription = health.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )

                    IconButton(
                        onClick = { isFavorite = !isFavorite },
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite
                            else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) Color.Red else Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = health.title,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = health.description)

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = "Manfaat: ${health.benefit}")

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        coroutineScope.launch {
                            isLoading = true
                            delay(2000)

                            snackbarHostState.showSnackbar(
                                "Materi ${health.title} berhasil dipelajari!"
                            )

                            isLoading = false
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = !isLoading
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp),
                            strokeWidth = 2.dp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Memproses...")
                    } else {
                        Text("Pelajari Sekarang")
                    }
                }
            }
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

