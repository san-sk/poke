package com.san.demo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.san.demo.utils.calculateLevel
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class PokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val level: Int,
    val hp: Int,
    val image:String
)

fun Pokemon.toEntity(): PokemonEntity {

    return PokemonEntity(
        id = this.id ?: -1,
        name = this.name ?: "NA",
        type = this.types?.map { it?.type?.name }?.joinToString(",") ?: "NA",
        level = calculateLevel(this.baseExperience ?: 0, "fast"),
        hp = this.stats?.get(0)?.baseStat ?: -1,
        image = this.sprites?.frontDefault ?: ""
    )

}