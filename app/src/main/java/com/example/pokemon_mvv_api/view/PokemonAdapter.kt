package com.example.pokemon_mvv_api.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pokemon_mvv_api.R
import com.example.pokemon_mvv_api.model.Data
import kotlinx.android.synthetic.main.pokemon_item_layout.view.*

class PokemonAdapter(private var pokemonList: List<Data>, private val pokemonDelegate: PokemonDelegate) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


//    private val pokemonDelegate: PokemonDelegate? = null

    interface PokemonDelegate {
        fun selectPokemon(pokemon: Data)
    }

    fun updatePokemons(pokemonList: List<Data>) {
        this.pokemonList = pokemonList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item_layout, parent, false)
        return PokemonViewHolder(itemView)
    }

    override fun getItemCount(): Int = pokemonList.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        pokemonList[position].let {
            holder.itemView.apply {
                name_textview.text = it.name
                hpower_textview.text = "HPower:  ${it.hp}"
            }
            Glide.with(holder.itemView)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(it.images.large)
                .into(holder.itemView.pokemon_image)



            holder.itemView.setOnClickListener {
                pokemonDelegate.selectPokemon(pokemonList[position])
            }
            }
        }
    }

