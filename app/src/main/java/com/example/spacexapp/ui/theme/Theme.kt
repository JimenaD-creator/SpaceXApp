package com.example.spacexapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1f1f1f),
    onPrimary = Color.White,
    surface = Color(0xFF121212),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF005687),
    onPrimary = Color.White,
    surface = Color(0xFFFAFAFA),
)

@Composable
fun SpaceXTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}