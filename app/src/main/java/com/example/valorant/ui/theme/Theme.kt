package com.example.valorant.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = ValorantRed,
    onPrimary = Color.Black,
    background = DarkBackground,
    surface = DarkBackground,
    onBackground = TextWhite,
    onSurface = TextWhite
)

@Composable
fun ValorantTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography(),
        content = content
    )
}
