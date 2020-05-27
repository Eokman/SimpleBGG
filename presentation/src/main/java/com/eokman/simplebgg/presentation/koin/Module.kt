package com.eokman.simplebgg.presentation.koin

import com.eokman.simplebgg.presentation.detail.BoardGameViewModel
import com.eokman.simplebgg.presentation.hot.HotBoardGameViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HotBoardGameViewModel(get()) }
    viewModel { BoardGameViewModel(get()) }
}