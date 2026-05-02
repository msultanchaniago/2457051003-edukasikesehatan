package com.example.msultanchaniago_2457051003_projectedukasikesehatan.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AppColorScheme = lightColorScheme(
    primary = HealthPrimary,
    secondary = HealthSecondary,
    background = HealthBackground,
    surface = HealthSurface,
    onPrimary = OnPrimaryText
)

@Composable
fun ProjectEdukasiKesehatanTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = AppTypography,
        content = content
    )
}