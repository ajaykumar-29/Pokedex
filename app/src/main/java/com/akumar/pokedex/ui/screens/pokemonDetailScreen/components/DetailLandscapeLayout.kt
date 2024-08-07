package com.akumar.pokedex.ui.screens.pokemonDetailScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.akumar.pokedex.data.remote.responses.Pokemon
import com.akumar.pokedex.util.Resource

@Composable
fun LandscapeLayout(
    pokemonImageSize: Dp,
    topPadding: Dp,
    pokemonDetail: Resource<Pokemon>
) {
    Row {
        Column(
            modifier = Modifier
                .weight(0.25f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (pokemonDetail is Resource.Success) {
                    pokemonDetail.data?.sprites?.let {
                        RotatingPokeball(pokemonImageSize * 2, topPadding)
                        AsyncImage(
                            model = it.other.officialArtwork.frontDefault,
                            contentDescription = pokemonDetail.data.name,
                            modifier = Modifier
                                .size(pokemonImageSize * 2)
                                .offset(y = topPadding)
                        )
                    }
                }
            }
        }
        Column(modifier = Modifier.weight(0.75f)) {
            PokemonDetailStateWrapper(
                pokemonDetail = pokemonDetail,
                modifier = Modifier
                    .fillMaxSize()
                    .shadow(10.dp, RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp),
                loadingModifier = Modifier
                    .size(100.dp)
                    .padding(
                        top = topPadding + pokemonImageSize / 2f,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
            )
        }
    }
}