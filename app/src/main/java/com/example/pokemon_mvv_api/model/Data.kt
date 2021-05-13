package com.example.pokemon_mvv_api.model

import java.io.Serializable

data class Data(
    val abilities: List<Ability>,
    val artist: String,
    val attacks: List<Attack>,
    val convertedRetreatCost: Int,
    val evolvesFrom: String,
    val evolvesTo: List<String>,
    val flavorText: String,
    val hp: String,
    val id: String,
    val images: Images,
    val legalities: Legalities,
    val level: String,
    val name: String,
    val nationalPokedexNumbers: List<Int>,
    val number: String,
    val rarity: String,
    val resistances: List<Resistance>,
    val retreatCost: List<String>,
    val rules: List<String>,
    val `set`: Set,
    val subtypes: List<String>,
    val supertype: String,
    val tcgplayer: Tcgplayer,
    val types: List<String>,
    val weaknesses: List<Weaknesse>
) : Serializable