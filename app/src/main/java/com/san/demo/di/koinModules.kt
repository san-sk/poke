package com.san.demo.di

import androidx.room.Room
import com.san.demo.data.PokeApi
import com.san.demo.data.db.PokeDataBase
import com.san.demo.data.repo.PokeRepoImplementation
import com.san.demo.domain.dao.PokemonDao
import com.san.demo.domain.repo.PokeRepository
import com.san.demo.utils.providesKtorClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.san.demo.domain.usecase.PokeUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import com.san.demo.presentation.pokescreens.PokeViewModel
import org.koin.android.ext.koin.androidApplication

val appModule = module {

}

val networkModule = module {
    single { providesKtorClient(true) }
    singleOf(::PokeApi)
}

val repoModule = module {
    single<PokeRepository> { PokeRepoImplementation(get(), get()) }

}

val viewModelModule = module {
    viewModelOf(::PokeViewModel)
}

val useCaseModule = module {
    singleOf(::PokeUseCase)
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            PokeDataBase::class.java, "poke-database"
        ).build()

    }

    single<PokemonDao> {
        val database = get<PokeDataBase>()
        database.pokeDao()
    }

}