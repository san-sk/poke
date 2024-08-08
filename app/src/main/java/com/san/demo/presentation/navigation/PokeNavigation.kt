package com.san.demo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.san.demo.presentation.pokescreens.PokeListScreen
import com.san.demo.presentation.pokescreens.PokemonDetailsScreen
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@OptIn(KoinExperimentalAPI::class)
@Composable
fun PokeNavigation(navController: NavHostController, modifier: Modifier) {

    NavHost(
        modifier = modifier,
        navController = navController, startDestination = PokeScreen.PokemonList.route
    ) {
        composable(PokeScreen.PokemonList.route) {
            KoinAndroidContext {
                PokeListScreen {
                    it?.let { it1 ->
                        navController.navigate(
                            PokeScreen.Pokemon.route.replace(
                                "{url}",
                                URLEncoder.encode(
                                    "https://pokeapi.co/api/v2/pokemon/${it1}/",
                                    StandardCharsets.UTF_8.toString()
                                )
                            )
                        )
                    }
                }
            }
        }

        composable(
            route = PokeScreen.Pokemon.route,
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) { backStackEntry ->

            KoinAndroidContext {
                backStackEntry.arguments?.getString("url")?.let {

                    PokemonDetailsScreen(
                        url = URLDecoder.decode(
                            it,
                            StandardCharsets.UTF_8.toString()
                        )
                    ) {
                        navController.navigateUp()
                    }
                }
            }
        }

    }
}

