package com.eokman.simplebgg.presentation.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.eokman.simplebgg.presentation.R
import com.eokman.simplebgg.presentation.model.BoardGame
import com.eokman.simplebgg.domain.entity.BoardGame as BoardGameEntity

fun BoardGameEntity.toModel() = BoardGame(
    id, name, imageUrl, thumbnail, yearpublished, description, minplayers, maxplayers, playingtime, minage, rank)

fun List<BoardGameEntity>.toListModel() = map { it.toModel() }

fun ImageView.setImagefromUrl(url: String?) {
    if(url == null){
        this.setImageResource(R.drawable.ic_logo_bgg)
    } else {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.ic_logo_bgg)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    }
}

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, url: String?) {
    view.setImagefromUrl(url)
}