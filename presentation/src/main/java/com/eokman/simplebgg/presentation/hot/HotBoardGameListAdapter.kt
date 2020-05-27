package com.eokman.simplebgg.presentation.hot

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.eokman.simplebgg.presentation.R
import com.eokman.simplebgg.presentation.databinding.ItemHotBoardGameBinding

class HotBoardGameListAdapter(fragment: Fragment,
                              private val viewModel: HotBoardGameViewModel,
                              private val listener: HotBoardGameFragment.OnFragmentInteractionListener?):
    RecyclerView.Adapter<HotBoardGameViewHolder>() {

    init {
        viewModel.hotBoardGames.observe(fragment, Observer {
            this.notifyDataSetChanged()
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotBoardGameViewHolder {
        val dataBinging = DataBindingUtil
            .inflate<ItemHotBoardGameBinding>(LayoutInflater.from(parent.context), R.layout.item_hot_board_game, parent, false)

        return HotBoardGameViewHolder(dataBinging).apply {
            itemView.setOnClickListener {
                listener?.onHotBoardGameItemClick(binding.boardgame?.id!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return viewModel.hotBoardGames.size()
    }

    override fun onBindViewHolder(holder: HotBoardGameViewHolder, position: Int) {
        val item = viewModel.hotBoardGames.get(position)
        holder.binding.apply {
            boardgame = item
        }
    }

}
