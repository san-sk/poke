package com.san.demo.presentation.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.san.demo.data.entity.Pokemon
import com.san.demo.data.entity.PokemonEntity
import com.san.demo.data.entity.PokemonList
import com.san.demo.utils.calculateLevel
import com.san.demo.utils.extractPokemonNumber
import com.san.demo.utils.getPokemonImageUrl


@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    PokemonCard(
        pokemon = PokemonEntity(
            name = "Pikachu",id=0, type = "", hp = 0, level = 7, image = ""
        )
    ) {

    }
}


@Composable
fun PokemonCard(
    pokemon: PokemonEntity,
    modifier: Modifier = Modifier,
    onClick: (url: Int?) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable {
                onClick(pokemon.id)
            }
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .background(Color.White)
                    .fillMaxHeight()
                    .align(Alignment.CenterVertically)
                    .padding(4.dp)
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                // Pokemon Name
                Text(
                    text = pokemon.name ?: "NA",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Pokemon Image
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = rememberAsyncImagePainter(pokemon.image),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )

                /*Image(
                    modifier = Modifier.weight(.1f),
                    painter = rememberAsyncImagePainter(pokemon.sprites?.backDefault),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )*/
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Pokemon Types
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(5.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier=Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Level: ${pokemon.level}",
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = "HP: ${pokemon.hp}",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Types:",
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = pokemon.type,
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Black)
                )

            }
        }
    }
}


