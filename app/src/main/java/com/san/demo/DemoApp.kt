package com.san.demo

import android.app.Application
import com.san.demo.di.appModule
import com.san.demo.di.databaseModule
import com.san.demo.di.networkModule
import com.san.demo.di.repoModule
import com.san.demo.di.useCaseModule
import com.san.demo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DemoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@DemoApp)
            modules(
                listOf(
                    appModule,
                    networkModule,
                    repoModule,
                    useCaseModule,
                    viewModelModule,
                    databaseModule
                )
            )
        }
    }
}