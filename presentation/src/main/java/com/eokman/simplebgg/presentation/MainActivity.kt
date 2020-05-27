package com.eokman.simplebgg.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.eokman.simplebgg.presentation.detail.BoardGameFragment
import com.eokman.simplebgg.presentation.hot.HotBoardGameFragment

class MainActivity : AppCompatActivity(), HotBoardGameFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fl_content, HotBoardGameFragment.newInstance())
            .commit()

    }

    override fun onHotBoardGameItemClick(itemId: String) {
        Log.d("emkim", "item ID : $itemId")
        supportFragmentManager.beginTransaction()
            .add(R.id.fl_content, BoardGameFragment.newInstance(itemId))
            .addToBackStack("Detail")
            .commitAllowingStateLoss()
    }
}
