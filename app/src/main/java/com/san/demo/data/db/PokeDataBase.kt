package com.san.demo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.san.demo.data.entity.PokemonEntity
import com.san.demo.domain.dao.PokemonDao

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokeDataBase : RoomDatabase() {
    abstract fun pokeDao(): PokemonDao
}

