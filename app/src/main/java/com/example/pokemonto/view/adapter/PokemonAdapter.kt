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
    private var pokelist: List<PokemonModel>
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivPokemon: ImageView = view.findViewById(R.id.ivPokemon)
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pok = pokelist[position]
        holder.tvNombre.text = pok.nombre
        holder.ivPokemon.setImageResource(pok.photo)
    }


    override fun getItemCount(): Int = pokelist.size

    fun updateList(newList: List<PokemonModel>) {
        pokelist = newList
        notifyDataSetChanged()
    }
}
