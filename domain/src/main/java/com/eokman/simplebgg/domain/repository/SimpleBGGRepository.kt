package com.eokman.simplebgg.domain.repository

import com.eokman.simplebgg.domain.Result
import com.eokman.simplebgg.domain.entity.BoardGame

interface SimpleBGGRepository {
    suspend fun getHotBoardGame(): Result<List<BoardGame>>
    suspend fun getBoardGame(id: String): Result<BoardGame>
}