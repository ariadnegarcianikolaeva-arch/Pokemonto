package com.example.pokemonto.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonto.R
import com.example.pokemonto.model.PokemonModel

class PokemonAdapter(
    private var pokelist: List<PokemonModel>,
    private val onItemClick: (PokemonModel) -> Unit,
    private val onFavoriteClick: (PokemonModel) -> Unit
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokelist[position])
    }

    override fun getItemCount(): Int = pokelist.size

    fun updateList(newList: List<PokemonModel>) {
        pokelist = newList
        notifyDataSetChanged()
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        private val ivPokemon: ImageView = itemView.findViewById(R.id.ivPokemon)
        private val ivFavorite: ImageView = itemView.findViewById(R.id.ivFavorito)

        fun bind(pokemon: PokemonModel) {
            tvNombre.text = pokemon.nombre
            ivPokemon.setImageResource(pokemon.photo)

            ivFavorite.setImageResource(
                if (pokemon.favorito)
                    R.drawable.if_fav
                else
                    R.drawable.if_borde
            )

            itemView.setOnClickListener {
                onItemClick(pokemon)
            }

            ivFavorite.setOnClickListener {
                onFavoriteClick(pokemon)
            }
        }
    }
}
