package com.example.pokemonto.view.adapter

class PokemonViewHolder {
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pok = pokelist[position]
        holder.tvNombre.text = pok.nombre
        holder.ivPokemon.setImageResource(pok.photo)
    }

}