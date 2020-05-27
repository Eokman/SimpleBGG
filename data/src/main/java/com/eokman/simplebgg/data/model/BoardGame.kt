package com.eokman.simplebgg.data.model

import com.eokman.simplebgg.domain.entity.BoardGame as BoardGameEntity

data class BoardGame(
    val id: String,
    val name: String,
    val imageUrl: String = "",
    val thumbnail: String = "",
    val yearpublished: Int = 0,
    val description: String = "",
    val minplayers: Int = 0,
    val maxplayers: Int = 0,
    val playingtime: Int = 0,
    val minage: Int = 0,
    val rank: Int = 0) {

    fun toEntity() = BoardGameEntity(id, name, imageUrl, thumbnail, yearpublished, description, minplayers, maxplayers, playingtime, minage, rank)

}

fun List<BoardGame>.toEntity(): List<BoardGameEntity> = map { it.toEntity() }

