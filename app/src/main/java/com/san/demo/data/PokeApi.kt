package com.san.demo.data

import com.san.demo.data.entity.Pokemon
import com.san.demo.data.entity.PokemonList
import com.san.demo.utils.Resource
import com.san.demo.utils.makeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.flow.Flow

class PokeApi(private val client: HttpClient) {

    private val baseUrl = "https://pokeapi.co/api/v2"
    private val pathPokemonList = "$baseUrl/pokemon"


    suspend fun fetchPokemonList(): PokemonList {
        return client.get {
            headers {
                append(HttpHeaders.Accept, "application/json")
            }
            url(pathPokemonList)
        }.body()
    }

    suspend fun fetchPokemon(url: String): Pokemon {
        return client.get(url).body()
    }

    suspend fun searchPokemon(name: String): Pokemon {
        return client.get("$pathPokemonList/$name").body()
    }

}