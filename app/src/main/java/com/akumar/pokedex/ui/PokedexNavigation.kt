package com.akumar.pokedex.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.akumar.pokedex.ui.screens.pokemonDetailScreen.PokemonDetailScreen
import com.akumar.pokedex.ui.screens.pokemonListScreen.PokemonListScreen

@Composable
fun PokedexNavigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "pokemon_list_screen"
    ) {
        composable("pokemon_list_screen") {
            PokemonListScreen(innerPadding,navController)
        }
        composable(
            "pokemon_detail_screen/{pokemonId}/{dominantColor}",
            arguments = listOf(
                navArgument("pokemonId") {
                    type = NavType.IntType
                },
                navArgument("dominantColor") {
                    type = NavType.IntType
                }
            )
        ) {
            val dominantColor = remember {
                val color = it.arguments?.getInt("dominantColor")
                color?.let { Color(it) } ?: Color.White
            }
            val pokemonId = remember {
                it.arguments?.getInt("pokemonId")
            }
            PokemonDetailScreen(
                innerPadding= innerPadding,
                dominantColor = dominantColor,
                pokemonId = pokemonId ?: -1,
                navController = navController
            )
        }
    }
}