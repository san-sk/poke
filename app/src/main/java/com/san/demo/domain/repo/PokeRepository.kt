package com.san.demo.domain.repo

import com.san.demo.data.entity.Pokemon
import com.san.demo.data.entity.PokemonEntity
import com.san.demo.data.entity.PokemonList
import com.san.demo.utils.BoundResource
import com.san.demo.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PokeRepository {

    suspend fun fetchPokemonList(): Flow<Resource<PokemonList>>

    suspend fun fetchPokemon(url:String): Flow<BoundResource<PokemonEntity>>

    suspend fun searchPokemon(name:String): Flow<BoundResource<List<PokemonEntity>>>

    suspend fun fetchPokemonDetail(url: String) : Flow<Resource<Pokemon>>
}