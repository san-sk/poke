package com.san.demo.utils

import androidx.compose.ui.graphics.Color


fun getTypeColor(typeName: String): Color {
    return when (typeName.lowercase()) {
        "grass" -> Color(0xFF78C850) // Example color
        "fire" -> Color(0xFFF08030)  // Example color
        "water" -> Color(0xFF6890F0)  // Example color
        // Add more types and colors here
        else -> Color.Gray
    }
}


// Example Kotlin function to calculate level based on XP and growth rate

fun calculateLevel(experience: Int, growthRate: String): Int {
    var level = 1
    var xpNeeded = 0

    when (growthRate) {
        "fast" -> {
            while (xpNeeded <= experience) {
                level++
                xpNeeded = (level * level * level * 0.8).toInt() // Formula for fast growth rate
            }
        }
        "medium-fast" -> {
            while (xpNeeded <= experience) {
                level++
                xpNeeded = (level * level * level).toInt() // Formula for medium-fast growth rate
            }
        }
        "medium-slow" -> {
            while (xpNeeded <= experience) {
                level++
                xpNeeded = (level * level * level * 1.2 - level * level * 15 + level * 100).toInt() // Formula for medium-slow growth rate
            }
        }
        "slow" -> {
            while (xpNeeded <= experience) {
                level++
                xpNeeded = (level * level * level * 1.2).toInt() // Formula for slow growth rate
            }
        }
        else -> throw IllegalArgumentException("Unknown growth rate")
    }

    return if (level > 100) 100 else level // Cap level at 100
}

