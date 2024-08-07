package com.akumar.pokedex.ui.screens.pokemonDetailScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.akumar.pokedex.data.remote.responses.Pokemon
import com.akumar.pokedex.util.Resource

@Composable
fun BoxScope.PortraitLayout(
    pokemonImageSize: Dp,
    topPadding: Dp,
    pokemonDetail: Resource<Pokemon>
) {
    Box(
        contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()
    ) {
        if (pokemonDetail is Resource.Success) {
            pokemonDetail.data?.sprites?.let {
                RotatingPokeball(pokemonImageSize, topPadding)
            }
        }
    }
    PokemonDetailStateWrapper(
        pokemonDetail = pokemonDetail,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = topPadding + pokemonImageSize * 2f / 3f + 30.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
            .shadow(10.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
            .align(Alignment.BottomCenter),
        loadingModifier = Modifier
            .size(100.dp)
            .align(Alignment.Center)
            .padding(
                top = topPadding + pokemonImageSize / 2f,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    )
    Box(
        contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()
    ) {
        if (pokemonDetail is Resource.Success) {
            pokemonDetail.data?.sprites?.let {
                AsyncImage(
                    model = it.other.officialArtwork.frontDefault,
                    contentDescription = pokemonDetail.data.name,
                    modifier = Modifier
                        .size(pokemonImageSize)
                        .offset(y = topPadding)
                )
            }
        }
    }
}