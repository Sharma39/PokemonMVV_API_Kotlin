package com.example.pokemon_mvv_api.model.network

import com.example.pokemon_mvv_api.model.PokemonResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class PokemonRetrofit {

    //URL -- https://api.pokemontcg.io/v2/cards?q=name:gardevoir

    //PokemonService.class
    private val pokemonService = createRetrofit().create(PokemonService::class.java)

    private fun createRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.pokemontcg.io/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun getPokemons(): Single<PokemonResponse> = pokemonService.getPokemons()

    interface PokemonService {
        @GET("/v2/cards")
        fun getPokemons(): Single<PokemonResponse>
    }

}