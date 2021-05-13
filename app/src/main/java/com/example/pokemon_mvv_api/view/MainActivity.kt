package com.example.pokemon_mvv_api.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.pokemon_mvv_api.R
import com.example.pokemon_mvv_api.model.Data
import com.example.pokemon_mvv_api.viewmodel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LifecycleOwner, PokemonAdapter.PokemonDelegate {
    private val viewModel: PokemonViewModel by viewModels()
    private val pokemonFragment: PokemonFragment = PokemonFragment()
    private val pokemonAdapter = PokemonAdapter(listOf(), this)

    private lateinit var adapter: PokemonFragment

    //@Override
    //protected void onCreate(Bundle savedInstanceState){//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.liveData.observe(this, { list ->
            pokemonAdapter.updatePokemons(list)
        })

        //Or by one line that is--- binding.mainRecyclerview.setAdapter(adapter);
        //Kotlin synthetics
        pokemon_recyclerview.adapter = pokemonAdapter
        val sHelper = LinearSnapHelper().also {
            it.attachToRecyclerView(pokemon_recyclerview)
        }

        viewModel.getPokemonsFromServer()

    }


    override fun selectPokemon(pokemon: Data) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show()
        val bundle = Bundle()
        bundle.putSerializable("news", pokemon)
        pokemonFragment.setArguments(bundle)

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
            .replace(R.id.main_frame, pokemonFragment)
            .addToBackStack(pokemonFragment.getTag())
            .commit()

    }

    fun example() {
        Toast.makeText(this, "Extra Extra - Read all about it!!", Toast.LENGTH_SHORT).show()
    }
}