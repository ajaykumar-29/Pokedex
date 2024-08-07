package com.akumar.pokedex.ui.screens.pokemonDetailScreen.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.akumar.pokedex.data.remote.responses.Pokemon
import com.akumar.pokedex.util.Resource

@Composable
fun PokemonDetailStateWrapper(
    pokemonDetail: Resource<Pokemon>,
    modifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier
) {
    when (pokemonDetail) {
        is Resource.Success -> {
            PokemonDetailSection(
                pokemonInfo = pokemonDetail.data!!, modifier = modifier.offset(y = (-20).dp)
            )
        }

        is Resource.Error -> {
            Text(
                text = pokemonDetail.message!!, color = Color.Red, modifier = modifier
            )
        }

        is Resource.Loading -> {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary, modifier = loadingModifier
            )
        }
    }
}