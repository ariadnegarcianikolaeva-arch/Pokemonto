package com.example.pokemonto.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonto.R
import com.example.pokemonto.view.adapter.PokemonAdapter
import com.example.pokemonto.viewmodel.PokemonViewModel

class PokedexFragment : Fragment() {

    private val pokemonViewModel: PokemonViewModel by activityViewModels()
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rPokemon)

        // Adapter con navegación al detalle
        pokemonAdapter = PokemonAdapter(emptyList()) { pokemon ->
            val bundle = Bundle().apply {
                putString("nombre", pokemon.nombre)
                putString("descripcion", pokemon.descripcion)
                putInt("foto", pokemon.photo)
            }

            findNavController().navigate(
                R.id.action_PokedexFragment_to_DetailsFragment,
                bundle
            )
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = pokemonAdapter
        }

        pokemonViewModel.pokemonList.observe(viewLifecycleOwner) { lista ->
            pokemonAdapter.updateList(lista)
        }
    }
}
