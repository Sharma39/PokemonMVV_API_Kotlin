package com.example.pokemon_mvv_api.model

data class PokemonResponse(
    val count: Int,
    val `data`: List<Data>,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int
)