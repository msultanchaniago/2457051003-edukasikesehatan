package com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.R
import com.example.msultanchaniago_2457051003_projectedukasikesehatan.navigation.AppScreen

@Composable
fun BottomMenu(
    selectedScreen: AppScreen,
    onMenuClick: (AppScreen) -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = selectedScreen == AppScreen.DASHBOARD,
            onClick = { onMenuClick(AppScreen.DASHBOARD) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Dashboard"
                )
            },
            label = {
                Text(text = "Dashboard")
            }
        )

        NavigationBarItem(
            selected = selectedScreen == AppScreen.EDUKASI,
            onClick = { onMenuClick(AppScreen.EDUKASI) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_book),
                    contentDescription = "Edukasi"
                )
            },
            label = {
                Text(text = "Edukasi")
            }
        )

        NavigationBarItem(
            selected = selectedScreen == AppScreen.TENTANG,
            onClick = { onMenuClick(AppScreen.TENTANG) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "Tentang"
                )
            },
            label = {
                Text(text = "Tentang")
            }
        )
    }
}