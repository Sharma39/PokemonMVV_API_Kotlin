package com.example.pokemon_mvv_api.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemon_mvv_api.model.Data
import com.example.pokemon_mvv_api.model.network.PokemonRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PokemonViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val pokemonRetrofit = PokemonRetrofit()
    val liveData = MutableLiveData<List<Data>>()

    fun getPokemonsFromServer() {

        compositeDisposable.add(
            pokemonRetrofit.getPokemons()
                .subscribeOn(
                    Schedulers.io()
                ).observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->

                    liveData.postValue(response.data)
                    compositeDisposable.clear()

                }, { throwable ->

                    compositeDisposable.clear()
                    Log.d("TAG_X", throwable.toString())

                })
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()

    }


}