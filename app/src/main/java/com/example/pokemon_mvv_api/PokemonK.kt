package com.example.pokemon_mvv_api

data class PokemonK(val message: String, val personName: String){

    constructor(message: String) : this(message, "")

}
