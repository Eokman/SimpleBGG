package com.eokman.simplebgg.presentation.model

import android.text.Html

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

    fun getDescriptionString(): String = Html.fromHtml(description).toString()
}