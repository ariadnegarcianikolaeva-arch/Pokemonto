package com.example.pokemonto.data

import com.example.pokemonto.model.PokemonModel
import com.example.pokemonto.model.PokemonRepository

class PokemonRepo {

    private val pokemons = PokemonRepository.lista.toMutableList()

    fun getPokemons(): List<PokemonModel> {
        return pokemons
    }

    fun removePokemon(position: Int) {
        pokemons.removeAt(position)
    }

    fun toggleFavorito(pokemon: PokemonModel) {
        pokemon.favorito = !pokemon.favorito
    }

    fun getFavorito(): List<PokemonModel> {
        return pokemons.filter { it.favorito }
    }

    fun searchByName(query: String): List<PokemonModel> {
        return pokemons.filter {
            it.nombre.contains(query, ignoreCase = true)
        }
    }
}
