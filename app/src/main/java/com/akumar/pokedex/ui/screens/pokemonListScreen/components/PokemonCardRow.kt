package com.akumar.pokedex.ui.screens.pokemonListScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akumar.pokedex.data.models.PokemonListObject

@Composable
fun PokemonCardRow(
    rowIndex: Int,
    pokemonList: List<PokemonListObject>,
    navController: NavController
) {
    Column {
        Row {
            PokemonCard(
                pokemon = pokemonList[rowIndex * 2],
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (pokemonList.size >= rowIndex * 2 + 2) {
                PokemonCard(
                    pokemon = pokemonList[rowIndex * 2 + 1],
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
