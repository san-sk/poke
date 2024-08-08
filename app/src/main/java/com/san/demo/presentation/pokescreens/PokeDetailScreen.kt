package com.san.demo.presentation.pokescreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.san.demo.data.entity.Pokemon
import com.san.demo.utils.getTypeColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokemonDetailsScreen(
    modifier: Modifier = Modifier,
    vm: PokeViewModel = koinViewModel(),
    url: String,
    goBack: () -> Unit,
) {
    val isLoading by vm.isLoading.collectAsState()
    val pokemonDetails by vm.pokemonDetails.collectAsState()
    val error by vm.error.collectAsState()

    LaunchedEffect(key1 = url) {
        vm.loadPokemonDetail(url)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        IconButton(modifier = Modifier.padding(horizontal = 24.dp).padding(top = 24.dp),
            onClick = { goBack() }) {
            Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back")
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 5.dp),
            contentAlignment = Alignment.Center
        ) {
            PokemonDetailsContent(pokemonDetails = pokemonDetails)
            if (isLoading) CircularProgressIndicator()
            if (error.isNotEmpty()) Text(
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
}

@Composable
fun PokemonDetailsContent(pokemonDetails: Pokemon?) {
    val imagePainter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(pokemonDetails?.sprites?.frontDefault)
            .size(Size.ORIGINAL)
            .build()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Pokémon Image
        Image(
            painter = imagePainter,
            contentDescription = "Pokémon Image",
            modifier = Modifier
                .size(200.dp)
                .padding(5.dp)
        )

        // Pokémon Name
        Text(
            text = pokemonDetails?.name?.uppercase() ?: "NA",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Pokémon Types
        Row(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            pokemonDetails?.types?.forEach { type ->
                TypeChip(type?.type?.name ?: "NA")
            }
        }

        // Pokémon Abilities
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "Abilities:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp).weight(1f)
            )
            pokemonDetails?.abilities?.forEach { ability ->
                Text(
                    text = ability?.ability?.name?.uppercase() ?: "NA",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp).weight(1f)
                )
            }
        }

        //attacks
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "Attacks:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp).weight(1f)
            )
            // pokemonDetails?.abilities?.forEach { ability ->
            Text(
                text = "NA",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp).weight(1f)
            )
            //}
        }

        //weakness
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "Weakness:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp).weight(1f)
            )
            //pokemonDetails?.abilities?.forEach { ability ->
            Text(
                text = "NA",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp).weight(1f)
            )
            //}
        }

        //resistance
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            Text(
                text = "Resistance:",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp).weight(1f)
            )
            //pokemonDetails?.abilities?.forEach { ability ->
            Text(
                text = "NA",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp).weight(1f)
            )
            //}
        }
    }
}

@Composable
fun TypeChip(typeName: String) {
    FilterChip(
        selected = false,
        onClick = {},
        modifier = Modifier.padding(4.dp),
        colors = FilterChipDefaults.filterChipColors(containerColor = getTypeColor(typeName)),
        label = {
            Text(text = typeName.uppercase(), color = Color.White)
        }
    )


}

@Preview(showBackground = true)
@Composable
fun PokemonDetailsScreenPreview() {
    PokemonDetailsContent(
        pokemonDetails = Pokemon(
            name = "Pikachu",
            sprites = Pokemon.Sprites(frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"),
            types = listOf(Pokemon.Type(type = Pokemon.Type.Type(name = "electric"))),
            abilities = listOf(Pokemon.Ability(Pokemon.Ability.Ability("static")))
        )
    )
}
