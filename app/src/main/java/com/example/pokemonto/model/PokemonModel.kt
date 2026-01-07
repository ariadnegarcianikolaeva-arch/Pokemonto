package com.example.pokemonto.model

data class PokemonModel(
    val nombre: String,
    val descripcion: String,
    val photo: Int,
    val favorito: Boolean= false
)