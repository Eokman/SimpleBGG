package com.eokman.simplebgg.data.source.remote

import com.eokman.simplebgg.data.model.BoardGame
import com.eokman.simplebgg.data.source.BGGDataSource
import com.eokman.simplebgg.domain.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BGGWebDataSource(private val bggWebApi: BGGWebApi, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): BGGDataSource{

    override suspend fun getHotBoardGame(): Result<List<BoardGame>> {
        return withContext(ioDispatcher) {
            try {
                val res = bggWebApi.getHotItem(BGGHotItemType.BOARDGAME)
                if(res.item.isNotEmpty()){
                    val hotItemList = ArrayList<BoardGame>()
                    for (hotBoardGameXml in res.item) {
                        hotItemList.add(hotBoardGameXml.toModel())
                    }
                    return@withContext Result.Success(hotItemList)
                }
                return@withContext Result.Error(java.lang.Exception("Item Empty"))
            }catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
    }

    override suspend fun getBoardGame(id: String): Result<BoardGame> {
        return withContext(ioDispatcher){
            try {
                val res = bggWebApi.getItem(id)
                if(res.item.isNotEmpty()){
                    return@withContext Result.Success(res.item[0].toModel())
                }
                return@withContext Result.Error(java.lang.Exception("Item Empty"))
            }catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
    }
}