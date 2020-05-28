package com.eokman.simplebgg.presentation.hot

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eokman.simplebgg.domain.Result
import com.eokman.simplebgg.domain.succeeded
import com.eokman.simplebgg.domain.usecase.GetHotBoardGame
import com.eokman.simplebgg.presentation.model.BoardGame
import com.eokman.simplebgg.presentation.util.ListLiveData
import com.eokman.simplebgg.presentation.util.toListModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HotBoardGameViewModel(private val useCase: GetHotBoardGame) : ViewModel() {

    val hotBoardGames = ListLiveData<BoardGame>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getHotBoardGame() {
        viewModelScope.launch {
            _isLoading.postValue(true)

            val result = useCase.get()

            if(result.succeeded) {
                val items = (result as Result.Success).data.toListModel()
                hotBoardGames.addAll(items)
            } else if (result is Result.Error){
                Log.e("emkim", result.exception.localizedMessage)
            }

            _isLoading.postValue(false)
        }
    }
}
