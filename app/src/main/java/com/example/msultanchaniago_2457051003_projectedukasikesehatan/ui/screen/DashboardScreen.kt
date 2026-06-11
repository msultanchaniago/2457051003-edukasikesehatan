package com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen

import androidx.annotation.DrawableRes
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.R

@Composable
fun DashboardScreen(
    userName: String,
    onOpenEducation: () -> Unit,
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7FAF7))
            .padding(20.dp)
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Color(0xFF66BB6A),
                                Color(0xFF26A69A)
                            )
                        )
                    )
                    .padding(20.dp)
            ) {
                Text(
                    text = "Halo, $userName",
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "Selamat datang di EduCare. Yuk mulai belajar kesehatan dasar hari ini.",
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = onOpenEducation) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_book),
                            contentDescription = "Mulai Edukasi",
                            modifier = Modifier.size(20.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(text = "Mulai Edukasi")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Ringkasan Aplikasi",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(10.dp))

        InfoCard(
            iconRes = R.drawable.ic_book,
            title = "Materi Edukasi",
            desc = "Berisi informasi kesehatan dasar seperti kebersihan, gizi, olahraga, minum air, dan tidur cukup."
        )

        InfoCard(
            iconRes = R.drawable.ic_health,
            title = "Data Online",
            desc = "Data edukasi kesehatan diambil dari GitHub Gist menggunakan Retrofit dan Gson."
        )

        InfoCard(
            iconRes = R.drawable.ic_info,
            title = "Tujuan Aplikasi",
            desc = "Membantu pengguna memahami kebiasaan hidup sehat secara sederhana dan mudah."
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
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
fun InfoCard(
    @DrawableRes iconRes: Int,
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
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = title,
                modifier = Modifier.size(36.dp),
                tint = Color(0xFF2E7D32)
            )

            Column(
                modifier = Modifier.padding(start = 14.dp)
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(text = desc)
            }
        }
    }
}