package com.akumar.pokedex.util

import androidx.compose.ui.graphics.Color

fun Color.with50PercentBlend(): Color {
    // Blend the color with white with 50% transparency
    val red = (this.red * 0.5f + 1.0f * 0.5f)
    val green = (this.green * 0.5f + 1.0f * 0.5f)
    val blue = (this.blue * 0.5f + 1.0f * 0.5f)
    return Color(red, green, blue, 1.0f)
}

fun Int.toThreeDigitString(): String {
    return String.format("%03d", this)
}