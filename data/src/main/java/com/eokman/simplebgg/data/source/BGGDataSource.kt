package com.eokman.simplebgg.data.source

import com.eokman.simplebgg.data.model.BoardGame
import com.eokman.simplebgg.domain.Result

interface BGGDataSource {

    suspend fun getHotBoardGame(): Result<List<BoardGame>>

    suspend fun getBoardGame(id: String): Result<BoardGame>

}