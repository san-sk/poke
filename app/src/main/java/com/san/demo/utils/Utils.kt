package com.san.demo.utils

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import java.util.regex.Pattern

fun extractPokemonNumber(url: String?): Int? {
    if (url == null) return null
    val pattern = Pattern.compile("https://pokeapi\\.co/api/v2/pokemon/(\\d+)/")
    val matcher = pattern.matcher(url)

    return if (matcher.find()) {
        matcher.group(1)?.toIntOrNull() // Extract and convert the captured group to an integer
    } else {
        null // Return null if the pattern doesn't match
    }
}

fun getPokemonImageUrl(id: Int?): String {
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}

fun extractDominantColor(bitmap: Bitmap): Color {
    val palette = Palette.from(bitmap).generate()
    val dominantSwatch = palette.dominantSwatch
    val color = dominantSwatch?.rgb ?: 0xFF000000.toInt() // Default to black if no dominant color found
    return Color(color)
}
