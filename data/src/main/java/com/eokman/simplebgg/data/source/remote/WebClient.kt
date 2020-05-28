package com.eokman.simplebgg.data.source.remote


import com.eokman.simplebgg.data.source.remote.model.BoardGameXMList
import com.eokman.simplebgg.data.source.remote.model.HotBoardGameXMList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BGGApiBaseUrl = "https://www.boardgamegeek.com/xmlapi2/"

interface BGGWebApi {

    @GET("hot")
    suspend fun getHotItem(@Query("type") type: BGGHotItemType): HotBoardGameXMList

    @GET("thing")
    suspend fun getItem(@Query("id") id: String): BoardGameXMList
}

fun createBGGWebApi(baseUrl: String): BGGWebApi {
    return Retrofit.Builder()
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                })
                .build())
        .baseUrl(baseUrl)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
        .create(BGGWebApi::class.java)
}

enum class BGGHotItemType {
    BOARDGAME,
    RPG,
    VIDEOGAME,
    BOARDGAMEPERSON,
    RPGPERSON,
    BOARDGAMECOMPANY,
    RPGCOMPANY,
    VIDEOGAMECOMPANY
}
