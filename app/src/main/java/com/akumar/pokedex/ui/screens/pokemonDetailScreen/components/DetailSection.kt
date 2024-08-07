package com.akumar.pokedex.ui.screens.pokemonDetailScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akumar.pokedex.data.remote.responses.Pokemon
import java.util.Locale

@Composable
fun PokemonDetailSection(
    pokemonInfo: Pokemon, modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .offset(y = 15.dp)
    ) {
        Text(
            text = "#${pokemonInfo.id} ${pokemonInfo.name.uppercase(Locale.ROOT)}",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            PokemonTypeSection(types = pokemonInfo.types)
            PokemonDetailDataSection(
                pokemonWeight = pokemonInfo.weight, pokemonHeight = pokemonInfo.height
            )
            PokemonBaseStats(pokemonInfo = pokemonInfo)
            Spacer(modifier = Modifier.height(8.dp))
            PokemonSpritesShowdown(pokemonInfo.sprites.versions.generationV.blackWhite.animated)
        }
    }
}
