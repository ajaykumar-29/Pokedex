package com.akumar.pokedex.ui.screens.pokemonDetailScreen

import androidx.lifecycle.ViewModel
import com.akumar.pokedex.data.remote.responses.Pokemon
import com.akumar.pokedex.repository.PokemonRepository
import com.akumar.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonId: Int): Resource<Pokemon> {
        return repository.getPokemonDetails(pokemonId)
    }
}