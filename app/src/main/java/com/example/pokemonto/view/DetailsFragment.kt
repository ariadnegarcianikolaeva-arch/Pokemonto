package com.example.pokemonto.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pokemonto.R

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivPokemon = view.findViewById<ImageView>(R.id.ivPokemonDetalle)
        val tvNombre = view.findViewById<TextView>(R.id.tvNombreDetalle)
        val tvDescripcion = view.findViewById<TextView>(R.id.tvDescripcionDetalle)

        arguments?.let {
            tvNombre.text = it.getString("nombre")
            tvDescripcion.text = it.getString("descripcion")
            ivPokemon.setImageResource(it.getInt("foto"))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(nombre: String, descripcion: String, foto: Int) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString("nombre", nombre)
                    putString("descripcion", descripcion)
                    putInt("foto", foto)
                }
            }
    }
}
