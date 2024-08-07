package com.akumar.pokedex.ui.screens.pokemonDetailScreen.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.akumar.pokedex.R
import kotlinx.coroutines.launch

@Composable
fun RotatingPokeball(pokemonImageSize: Dp, topPadding: Dp) {
    val rotationAngle = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        // Continuously animate the rotation angle
        coroutineScope.launch {
            rotationAngle.animateTo(
                targetValue = 360f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 2000,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    Image(
        painter = painterResource(R.drawable.pokeball),
        contentDescription = "pokeball",
        alpha = 0.5f,
        modifier = Modifier
            .size(pokemonImageSize)
            .offset(y = topPadding)
            .graphicsLayer(rotationZ = rotationAngle.value)
    )
}