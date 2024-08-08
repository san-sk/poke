package com.san.demo.presentation.pokescreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.san.demo.data.entity.Pokemon
import com.san.demo.data.entity.PokemonEntity
import com.san.demo.data.entity.PokemonList
import com.san.demo.domain.usecase.PokeUseCase
import com.san.demo.utils.BoundResource
import com.san.demo.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PokeViewModel(private val useCase: PokeUseCase) : ViewModel() {

    var isLoading = MutableStateFlow(false)
    var error = MutableStateFlow("")
    var lastPageReached = MutableStateFlow(false)

    private val _pokemonList = MutableStateFlow<List<PokemonEntity?>>(listOf())
    val pokeList = _pokemonList.asStateFlow()

    private val _pokemonDetails = MutableStateFlow<Pokemon?>(null)
    val pokemonDetails = _pokemonDetails.asStateFlow()

    fun loadPokemonList() {

        viewModelScope.launch {
            useCase.invoke()
                .collectLatest {
                    when (it) {
                        is Resource.Error -> {
                            error.value = it.exception.message ?: "Something went wrong"
                        }

                        is Resource.Loader -> {
                            isLoading.value = it.isLoading
                        }

                        is Resource.Success -> {
                            error.value = ""
                            it.result.results?.let { list ->
                                // _pokemonList.value = list
                                list.forEach {
                                    it?.url?.let { it1 -> loadPokemon(it1) }
                                }
                                // loadPokemon(list[0]?.url ?: "")
                            }
                        }
                    }
                }
        }

    }

    fun loadPokemon(url: String) {

        viewModelScope.launch {
            useCase.invokePokemon(url)
                .collectLatest {
                    when (it) {

                        is BoundResource.Error -> {
                            error.value = it.exception.message ?: "Something went wrong"
                            it.result.let { poke ->
                                _pokemonList.value = pokeList.value.plus(poke)
                                //_pokemonDetails.value = poke
                            }
                        }

                        is BoundResource.Loading -> {
                            isLoading.value = it.isLoading
                        }

                        is BoundResource.Success -> {
                            error.value = ""
                            it.result.let { poke ->
                                _pokemonList.value = pokeList.value.plus(poke)
                                //_pokemonDetails.value = poke
                            }
                        }
                    }
                }
        }

    }

    fun loadPokemonDetail(url: String) {

        viewModelScope.launch {
            useCase.fetchPokemonDetail(url)
                .collectLatest {
                    when (it) {

                        is Resource.Error -> {
                            error.value = it.exception.message ?: "Something went wrong"
                        }

                        is Resource.Loader -> {
                            isLoading.value = it.isLoading
                        }

                        is Resource.Success -> {
                            error.value = ""
                            it.result.let { poke ->
                                _pokemonDetails.value = poke
                            }
                        }
                    }
                }
        }

    }

    fun searchPokemon(name: String) {

        viewModelScope.launch {
            useCase.searchPokemon(name)
                .collectLatest {
                    when (it) {

                        is BoundResource.Error -> {
                            error.value = it.exception.message ?: "Something went wrong"
                            it.result.let { poke ->
                               // _pokemonList.value = pokeList.value.plus(poke)
                            }
                        }

                        is BoundResource.Loading -> {
                            isLoading.value = it.isLoading
                            _pokemonList.value = listOf()
                        }

                        is BoundResource.Success -> {
                            error.value = ""
                            it.result.let { poke ->
                                _pokemonList.value = poke
                            }
                        }
                    }
                }
        }

    }


    init {
        loadPokemonList()
    }
}