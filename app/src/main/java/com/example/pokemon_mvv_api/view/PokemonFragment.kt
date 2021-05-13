package com.example.pokemon_mvv_api.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.pokemon_mvv_api.R
import com.example.pokemon_mvv_api.model.Data
import kotlinx.android.synthetic.main.pokemon_fragment_layout.*

class PokemonFragment: Fragment() {

    private var nInterface: PokeInterface? = null

    interface PokeInterface {
        fun example()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pokemon_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemon: Data? = arguments!!.getSerializable("news") as Data?
        if (pokemon != null) {
            (name_fragview as TextView).text = pokemon.name
            (view.findViewById<View>(R.id.hp_fragview) as TextView).text = "HPower: ${pokemon.hp}"
            (view.findViewById<View>(R.id.rarity_fragview) as TextView).text = "Rarity:  ${ pokemon.rarity}"

            if(pokemon.level == null){
                (view.findViewById<View>(R.id.level_fragview) as TextView).text = "Level: Basic"
            }
            else {
                (view.findViewById<View>(R.id.level_fragview) as TextView).text =
                    "Level:  ${pokemon.level}"
            }

            Glide.with(view)
                .applyDefaultRequestOptions(RequestOptions.centerCropTransform())
                .load(pokemon.images.large)
                .into(image_fragmentview)


        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
////        nInterface = context as PokeInterface
//        nInterface!!.example()
    }

}