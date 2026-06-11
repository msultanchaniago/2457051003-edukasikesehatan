package com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.R

@Composable
fun LoginScreen(
    onLoginSuccess: (String) -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var npm by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFFE8F5E9),
                        Color(0xFFFFFFFF)
                    )
                )
            )
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "EduCare",
            style = MaterialTheme.typography.headlineLarge,
            color = Color(0xFF2E7D32)
        )

        Text(
            text = "Aplikasi Edukasi Kesehatan Dasar",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Masuk ke Aplikasi",
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = nama,
                    onValueChange = { nama = it },
                    label = {
                        Text(text = "Nama")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "Nama",
                            modifier = Modifier.size(22.dp)
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = npm,
                    onValueChange = { npm = it },
                    label = {
                        Text(text = "NPM")
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_login),
                            contentDescription = "NPM",
                            modifier = Modifier.size(22.dp)
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                if (errorMessage.isNotEmpty()) {
                    Text(
                        text = errorMessage,
                        color = Color.Red
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                }

                Button(
                    onClick = {
                        if (nama.isBlank() || npm.isBlank()) {
                            errorMessage = "Nama dan NPM wajib diisi"
                        } else {
                            errorMessage = ""
                            onLoginSuccess(nama)
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_login),
                            contentDescription = "Login",
                            modifier = Modifier.size(20.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(text = "Masuk")
                    }
                }
            }
        }
    }
}