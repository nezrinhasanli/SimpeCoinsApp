package com.nezrin.coinsapp.domain.repository

import androidx.lifecycle.LiveData
import com.nezrin.coinsapp.data.model.CoinResponseById
import com.nezrin.coinsapp.data.model.CoinsResponse
import com.nezrin.coinsapp.domain.model.CoinsResponseItem
import retrofit2.Response

interface CoinsRepo {
    suspend fun getCoins():Response<List<CoinsResponseItem>>

    suspend fun getCoinById(id:String):Response<CoinResponseById>

    fun getCoinFromRoom():LiveData<List<CoinsResponseItem>>
}