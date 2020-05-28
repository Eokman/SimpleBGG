package com.eokman.simplebgg.data.repository

import com.eokman.simplebgg.data.model.toEntity
import com.eokman.simplebgg.data.source.remote.BGGWebDataSource
import com.eokman.simplebgg.domain.Result
import com.eokman.simplebgg.domain.entity.BoardGame
import com.eokman.simplebgg.domain.repository.SimpleBGGRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class SimpleBGGRepositoryImpl(private val remoteDataSource: BGGWebDataSource, private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO): SimpleBGGRepository {

    override suspend fun getHotBoardGame(): Result<List<BoardGame>> {
        return withContext(ioDispatcher) {
            when(val result = remoteDataSource.getHotBoardGame()) {
                is Result.Success -> {
                    val list: List<BoardGame> = result.data.toEntity()
                    Result.Success(list)
                }
                is Result.Error -> Result.Error(result.exception)
            }
        }
    }

    override suspend fun getBoardGame(id: String): Result<BoardGame> {
        return withContext(ioDispatcher) {
            when(val result = remoteDataSource.getBoardGame(id)) {
                is Result.Success -> {
                    Result.Success(result.data.toEntity())
                }
                is Result.Error -> Result.Error(Exception(""))
            }
        }
    }

}