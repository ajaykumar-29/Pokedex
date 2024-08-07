package com.akumar.pokedex.ui.screens.pokemonListScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akumar.pokedex.R
import com.akumar.pokedex.ui.screens.pokemonListScreen.components.PokemonList
import com.akumar.pokedex.ui.theme.pokemonColor


@Composable
fun PokemonListScreen(
    innerPadding: PaddingValues,
    navController: NavController
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val innerPaddingValue by remember {
        mutableStateOf(
            if (screenWidth < 600.dp) innerPadding else PaddingValues(
                0.dp
            )
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .background(pokemonColor)
    )
    Column(
        modifier = Modifier
            .padding(innerPaddingValue)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pokemon_logo),
            contentDescription = "Pokemon",
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
                .background(pokemonColor)
        )
        Divider(
            modifier = Modifier.shadow(10.dp, spotColor = pokemonColor),
            color = Color(0x55ffde00)
        )
        PokemonList(navController = navController)
    }
}