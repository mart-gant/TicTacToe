package com.mart_gant.tictactoe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun TicTacToeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorPalette
    } else {
        lightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

private val lightColorPalette = androidx.compose.material3.lightColorScheme(
    primary = Blue500,
    primaryContainer = Blue200,
    secondary = Red500,
    background = LightGray,
    surface = White,
    onPrimary = White,
    onSecondary = White,
    onBackground = Black,
    onSurface = Black
)

private val darkColorPalette = androidx.compose.material3.darkColorScheme(
    primary = Blue700,
    primaryContainer = Blue500,
    secondary = Green500,
    background = Gray,
    surface = Black,
    onPrimary = Black,
    onSecondary = Black,
    onBackground = White,
    onSurface = White
)
