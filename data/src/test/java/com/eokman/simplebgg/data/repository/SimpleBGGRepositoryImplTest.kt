package com.eokman.simplebgg.data.repository

import com.eokman.simplebgg.data.DefaultDispatcherProvider
import com.eokman.simplebgg.data.MainCoroutineRule
import com.eokman.simplebgg.data.source.remote.BGGApiBaseUrl
import com.eokman.simplebgg.data.source.remote.BGGHotItemType
import com.eokman.simplebgg.data.source.remote.BGGWebDataSource
import com.eokman.simplebgg.data.source.remote.createBGGWebApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SimpleBGGRepositoryImplTest {

    private lateinit var repo: SimpleBGGRepositoryImpl

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun createRepository() {
        val bggWebDataSource = BGGWebDataSource(createBGGWebApi(BGGApiBaseUrl))
        repo = SimpleBGGRepositoryImpl(bggWebDataSource, mainCoroutineRule.testDispatcherProvider.default())
    }

//    @Test
//    fun testGetHotBoardGame() = runBlockingTest {
//        val result = async { repo.getHotBoardGame() }.await()
//        print(result.toString())
//    }

//    @Test
//    fun testGetHotBoardGame() = mainCoroutineRule.testDispatcher.runBlockingTest {
//        val bggWebDataSource = BGGWebDataSource(createBGGWebApi(), mainCoroutineRule.testDispatcherProvider.io())
//        val repo = SimpleBGGRepositoryImpl(bggWebDataSource, mainCoroutineRule.testDispatcherProvider.io())
//        val result = repo.getHotBoardGame()
//
//        print(result.toString())
//        assertNotNull(result)
//    }

    @Test
    fun getBoardGame() {
    }
}