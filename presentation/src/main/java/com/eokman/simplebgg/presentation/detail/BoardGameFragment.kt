package com.eokman.simplebgg.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.eokman.simplebgg.presentation.R
import com.eokman.simplebgg.presentation.databinding.BoardGameFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class BoardGameFragment : Fragment() {

    companion object {

        private const val ARG_BOARDGAME_ID = "id"

        fun newInstance(boardGameId: String) =
            BoardGameFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_BOARDGAME_ID, boardGameId)
                }
            }
    }

    private var boardGameId: String? = null

    private val viewModel: BoardGameViewModel by viewModel()

    private lateinit var databinding: BoardGameFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            boardGameId = it.getString(ARG_BOARDGAME_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        databinding = DataBindingUtil
            .inflate<BoardGameFragmentBinding>(inflater, R.layout.board_game_fragment, container, false)
            .apply {
                vm = viewModel
                lifecycleOwner = this@BoardGameFragment
            }
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (boardGameId != null){
            viewModel.getBoardGame(boardGameId!!)
        }
    }

}
