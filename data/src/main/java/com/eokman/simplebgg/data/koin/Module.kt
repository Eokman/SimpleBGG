package com.eokman.simplebgg.data.koin

import com.eokman.simplebgg.data.repository.SimpleBGGRepositoryImpl
import com.eokman.simplebgg.data.source.remote.BGGApiBaseUrl
import com.eokman.simplebgg.data.source.remote.BGGWebDataSource
import com.eokman.simplebgg.data.source.remote.createBGGWebApi
import com.eokman.simplebgg.domain.repository.SimpleBGGRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { createBGGWebApi(BGGApiBaseUrl) }
    single { BGGWebDataSource(get()) }
    single<SimpleBGGRepository> { SimpleBGGRepositoryImpl(get()) }
}