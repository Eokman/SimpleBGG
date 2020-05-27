package com.eokman.simplebgg.domain.usecase

import com.eokman.simplebgg.domain.Result
import com.eokman.simplebgg.domain.entity.BoardGame
import com.eokman.simplebgg.domain.repository.SimpleBGGRepository

class GetHotBoardGame(private val repository: SimpleBGGRepository) {
    suspend fun get(): Result<List<BoardGame>> {
        return repository.getHotBoardGame()
    }
}