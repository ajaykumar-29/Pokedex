package com.akumar.pokedex.data.remote

import com.akumar.pokedex.data.remote.responses.Pokemon
import com.akumar.pokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int, @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Int): Pokemon
}