package com.eokman.simplebgg.presentation.hot

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.eokman.simplebgg.presentation.R
import com.eokman.simplebgg.presentation.databinding.HotBoardGameFragmentBinding
import kotlinx.android.synthetic.main.hot_board_game_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class HotBoardGameFragment : Fragment() {

    companion object {
        fun newInstance() = HotBoardGameFragment()
    }

    private lateinit var databinding: HotBoardGameFragmentBinding
    private var listener: OnFragmentInteractionListener? = null
    private val viewModel: HotBoardGameViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        databinding = DataBindingUtil
            .inflate<HotBoardGameFragmentBinding>(inflater, R.layout.hot_board_game_fragment, container, false)
            .apply {
                vm = viewModel
                lifecycleOwner = this@HotBoardGameFragment
            }
        return databinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(rv_list) {
            adapter = HotBoardGameListAdapter(this@HotBoardGameFragment, viewModel, listener)

            layoutManager = LinearLayoutManager(context)

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        viewModel.getHotBoardGame()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onHotBoardGameItemClick(itemId: String)
    }
}
