package com.example.pokemonto.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.pokemonto.R
import com.example.pokemonto.viewmodel.PokemonViewModel

class PokedexFragment : Fragment() {

    private val politicosViewModel: PokemonViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        politicosViewModel.pokemonList.observe(viewLifecycleOwner) { lista ->
            // De momento no hacemos nada
            // Aquí llegan los datos correctamente
        }
    }
}