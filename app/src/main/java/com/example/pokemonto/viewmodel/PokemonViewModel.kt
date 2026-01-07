package com.example.pokemonto.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonto.model.PokemonModel
import com.example.pokemonto.model.PokemonRepository

class PokemonViewModel : ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonModel>>()
    val pokemonList: LiveData<List<PokemonModel>> = _pokemonList

    init {
        _pokemonList.value = PokemonRepository.lista
    }

    fun removePokemon(position: Int) {
        val currentList = _pokemonList.value?.toMutableList() ?: return
        currentList.removeAt(position)
        _pokemonList.value = currentList
    }
}
