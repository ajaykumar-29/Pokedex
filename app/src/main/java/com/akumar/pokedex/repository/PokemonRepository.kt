package com.akumar.pokedex.repository

import com.akumar.pokedex.data.remote.PokeApi
import com.akumar.pokedex.data.remote.responses.Pokemon
import com.akumar.pokedex.data.remote.responses.PokemonList
import com.akumar.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val pokeApi: PokeApi) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            pokeApi.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("Something went wrong")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonDetails(pokemonId: Int): Resource<Pokemon> {
        val response = try {
            pokeApi.getPokemonDetails(pokemonId)
        } catch (e: Exception) {
            return Resource.Error("Something went wrong")
        }
        return Resource.Success(response)
    }
}