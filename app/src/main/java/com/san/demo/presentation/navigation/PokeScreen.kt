package com.san.demo.presentation.navigation

import androidx.annotation.StringRes
import com.san.demo.R


sealed class PokeScreen(val route: String, @StringRes val resourceId: Int) {
    data object Pokemon : PokeScreen("poke_detail/{url}", R.string.pokemon)
    data object PokemonList : PokeScreen("poke_list", R.string.pokemon_list)
}
