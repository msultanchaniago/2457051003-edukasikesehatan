package com.example.msultanchaniago_2457051003_projectedukasikesehatan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.model.Health
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.navigation.AppScreen
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.component.BottomMenu
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen.AboutScreen
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen.DashboardScreen
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen.DetailScreen
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen.EducationScreen
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.screen.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EduCareApp()
        }
    }
}

@Composable
fun EduCareApp() {
    var isLoggedIn by remember { mutableStateOf(false) }
    var userName by remember { mutableStateOf("") }
    var selectedScreen by remember { mutableStateOf(AppScreen.DASHBOARD) }
    var selectedHealth by remember { mutableStateOf<Health?>(null) }

    if (!isLoggedIn) {
        LoginScreen(
            onLoginSuccess = { name ->
                userName = name
                isLoggedIn = true
                selectedScreen = AppScreen.DASHBOARD
                selectedHealth = null
            }
        )
    } else {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = if (selectedHealth == null) 82.dp else 0.dp)
            ) {
                if (selectedHealth != null) {
                    DetailScreen(
                        health = selectedHealth!!,
                        onBack = {
                            selectedHealth = null
                        }
                    )
                } else {
                    when (selectedScreen) {
                        AppScreen.DASHBOARD -> {
                            DashboardScreen(
                                userName = userName,
                                onOpenEducation = {
                                    selectedScreen = AppScreen.EDUKASI
                                },
                                onLogout = {
                                    isLoggedIn = false
                                    userName = ""
                                    selectedScreen = AppScreen.DASHBOARD
                                    selectedHealth = null
                                }
                            )
                        }

                        AppScreen.EDUKASI -> {
                            EducationScreen(
                                onItemClick = { health ->
                                    selectedHealth = health
                                }
                            )
                        }

                        AppScreen.TENTANG -> {
                            AboutScreen(
                                onLogout = {
                                    isLoggedIn = false
                                    userName = ""
                                    selectedScreen = AppScreen.DASHBOARD
                                    selectedHealth = null
                                }
                            )
                        }
                    }
                }
            }

            if (selectedHealth == null) {
                Box(
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    BottomMenu(
                        selectedScreen = selectedScreen,
                        onMenuClick = { screen ->
                            selectedScreen = screen
                            selectedHealth = null
                        }
                    )
                }
            }
        }
    }
}