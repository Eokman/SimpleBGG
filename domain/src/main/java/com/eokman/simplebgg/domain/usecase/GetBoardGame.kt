package com.eokman.simplebgg.domain.usecase

import com.eokman.simplebgg.domain.Result
import com.eokman.simplebgg.domain.entity.BoardGame
import com.eokman.simplebgg.domain.repository.SimpleBGGRepository

class GetBoardGame(private val repository: SimpleBGGRepository) {
    suspend fun get(id: String): Result<BoardGame> {
        return repository.getBoardGame(id)
    }
}