package com.san.demo.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.san.demo.data.entity.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM PokemonEntity")
    fun getAll(): Flow<List<PokemonEntity>>

    @Query("SELECT * FROM PokemonEntity WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): Flow<List<PokemonEntity>>

    @Query("SELECT * FROM PokemonEntity WHERE id IN (:pokeId)")
    fun findById(pokeId: Int): Flow<PokemonEntity>

    @Query("SELECT * FROM PokemonEntity WHERE name LIKE '%' || :name || '%'")
    fun findByName(name: String): Flow<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg pokemon: PokemonEntity)

    @Delete
    fun delete(pokemon: PokemonEntity)


}