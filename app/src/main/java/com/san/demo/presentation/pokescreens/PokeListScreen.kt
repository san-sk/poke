package com.san.demo.presentation.pokescreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.san.demo.data.entity.Pokemon
import com.san.demo.presentation.components.PokeSearch
import com.san.demo.presentation.components.PokemonCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokeListScreen(
    modifier: Modifier = Modifier,
    vm: PokeViewModel = koinViewModel(),
    onClick: (url: Int?) -> Unit
) {
    val isLoading by vm.isLoading.collectAsState()
    val pokes by vm.pokeList.collectAsState()
    val error by vm.error.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clickable {
                        vm.loadPokemonList()
                    },
                text = "Poke",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                PokeSearch(modifier = Modifier.weight(.9f), threshold = 3, onClear = {
                    vm.loadPokemonList()
                }) {
                    vm.searchPokemon(it)
                }
                IconButton(
                    modifier = Modifier
                        .weight(.1f)
                        .padding(end = 20.dp),
                    onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "sort")
                }
            }


            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                //columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)

            ) {
                items(pokes) { item ->
                    item?.let {
                        PokemonCard(pokemon = it) {
                            onClick(it)
                        }
                    }

                }
            }

        }

        if (isLoading) CircularProgressIndicator()
        if (error.isNotEmpty() && pokes.isEmpty()) Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(10.dp),
            text = error,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Red
        )
    }


}

@Preview
@Composable
private fun PokeListPreview() {
    PokeListScreen {

    }

}