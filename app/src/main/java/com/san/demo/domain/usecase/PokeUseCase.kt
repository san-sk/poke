package com.san.demo.domain.usecase

import com.san.demo.domain.repo.PokeRepository

class PokeUseCase(private val repository: PokeRepository) {


    suspend operator fun invoke() = repository.fetchPokemonList()

    suspend fun invokePokemon(url: String) = repository.fetchPokemon(url = url)

    suspend fun fetchPokemonDetail(url: String) = repository.fetchPokemonDetail(url = url)

    suspend fun searchPokemon(name:String) = repository.searchPokemon(name)
}