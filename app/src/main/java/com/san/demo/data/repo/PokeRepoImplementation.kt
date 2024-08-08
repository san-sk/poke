package com.san.demo.data.repo

import com.san.demo.data.PokeApi
import com.san.demo.data.entity.Pokemon
import com.san.demo.data.entity.PokemonEntity
import com.san.demo.data.entity.PokemonList
import com.san.demo.data.entity.toEntity
import com.san.demo.domain.dao.PokemonDao
import com.san.demo.domain.repo.PokeRepository
import com.san.demo.utils.BoundResource
import com.san.demo.utils.Resource
import com.san.demo.utils.extractPokemonNumber
import com.san.demo.utils.makeApiCall
import com.san.demo.utils.networkBoundResource
import com.san.demo.utils.networkOnlyResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map

class PokeRepoImplementation(private val pokeApi: PokeApi, private val dao: PokemonDao) :
    PokeRepository {

    override suspend fun fetchPokemonList(): Flow<Resource<PokemonList>> {
        return makeApiCall { pokeApi.fetchPokemonList() }
    }

    override suspend fun fetchPokemon(url: String): Flow<BoundResource<PokemonEntity>> {
        val id = extractPokemonNumber(url) ?: -1
        return networkBoundResource(
            query = {
                dao.findById(id)
            },
            fetch = {
                pokeApi.fetchPokemon(url)
            },
            shouldFetch = {
                it?.id == id
            },
            saveFetchResult = {
                dao.insertAll(it.toEntity())
            }
        )
    }

    override suspend fun searchPokemon(name: String): Flow<BoundResource<List<PokemonEntity>>> {
        return networkBoundResource(
            query = {
                dao.findByName(name)
            },
            fetch = {
                pokeApi.searchPokemon(name)
            },
            shouldFetch = {
                it.isNullOrEmpty()
            },
            saveFetchResult = {
                dao.insertAll(it.toEntity())
            }
        )
    }

    override suspend fun fetchPokemonDetail(url: String): Flow<Resource<Pokemon>> {
       return makeApiCall { pokeApi.fetchPokemon(url) }

    }

}