package com.akumar.pokedex.ui.screens.pokemonDetailScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akumar.pokedex.data.remote.responses.Animated

@Composable
fun PokemonSpritesShowdown(pokemonShowdown: Animated, imageSize: Dp = 85.dp) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.padding(2.dp),
            text = "Showdown :",
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            GifImageColumn(
                url = pokemonShowdown.frontDefault,
                name = "Front Sprite",
                imageSize = imageSize
            )
            GifImageColumn(
                url = pokemonShowdown.backDefault,
                name = "Back Sprite",
                imageSize = imageSize
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            GifImageColumn(
                url = pokemonShowdown.frontShiny,
                name = "Front Shiny",
                imageSize = imageSize
            )
            GifImageColumn(
                url = pokemonShowdown.backShiny,
                name = "Back Shiny",
                imageSize = imageSize
            )
        }
    }
}