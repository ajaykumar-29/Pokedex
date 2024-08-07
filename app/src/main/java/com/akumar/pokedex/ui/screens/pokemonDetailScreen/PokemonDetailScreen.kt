package com.akumar.pokedex.ui.screens.pokemonDetailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.akumar.pokedex.data.remote.responses.Pokemon
import com.akumar.pokedex.ui.screens.pokemonDetailScreen.components.LandscapeLayout
import com.akumar.pokedex.ui.screens.pokemonDetailScreen.components.PokemonDetailHeader
import com.akumar.pokedex.ui.screens.pokemonDetailScreen.components.PortraitLayout
import com.akumar.pokedex.util.Resource

@Composable
fun PokemonDetailScreen(
    innerPadding: PaddingValues,
    pokemonId: Int,
    dominantColor: Color,
    navController: NavController,
    pokemonImageSize: Dp = 200.dp,
    topPadding: Dp = 20.dp,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val pokemonDetail by produceState<Resource<Pokemon>>(initialValue = Resource.Loading()) {
        value = viewModel.getPokemonInfo(pokemonId)
    }

    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    val isLandscape by remember(screenWidthDp) { mutableStateOf(screenWidthDp > 600) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(dominantColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .background(
                    Brush.verticalGradient(
                        listOf(Color.Black, Color.Transparent)
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(bottom = 16.dp)
        ) {
            PokemonDetailHeader(
                navController, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f)
            )
            if (isLandscape) {
                LandscapeLayout(pokemonImageSize, topPadding, pokemonDetail)
            } else {
                PortraitLayout(pokemonImageSize, topPadding, pokemonDetail)
            }
        }
    }
}
