package com.eokman.simplebgg.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eokman.simplebgg.domain.Result
import com.eokman.simplebgg.domain.succeeded
import com.eokman.simplebgg.domain.usecase.GetBoardGame
import com.eokman.simplebgg.presentation.model.BoardGame
import com.eokman.simplebgg.presentation.util.toModel
import kotlinx.coroutines.launch

class BoardGameViewModel(private val useCase: GetBoardGame) : ViewModel() {
    private val _boardgame = MutableLiveData<BoardGame>()
    val boardgame: LiveData<BoardGame> get() = _boardgame

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun getBoardGame(id: String) {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = useCase.get(id)

            if(result.succeeded) {
                _boardgame.postValue((result as Result.Success).data.toModel())
            } else if (result is Result.Error){
                Log.e("emkim", result.exception.localizedMessage)
            }
            _isLoading.postValue(false)
        }
    }
}
