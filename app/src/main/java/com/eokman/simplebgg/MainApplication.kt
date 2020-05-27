package com.eokman.simplebgg

import android.app.Application
import com.eokman.simplebgg.data.koin.repositoryModule
import com.eokman.simplebgg.domain.usecase.GetBoardGame
import com.eokman.simplebgg.domain.usecase.GetHotBoardGame
import com.eokman.simplebgg.presentation.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication: Application() {

    private val useCaseModule = module {
        factory { GetHotBoardGame(get()) }
        factory { GetBoardGame(get()) }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                listOf(repositoryModule, useCaseModule, viewModelModule)
            )
        }
    }
}