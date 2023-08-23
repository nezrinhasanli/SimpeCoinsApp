package com.nezrin.coinsapp.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.nezrin.coinsapp.data.local.CoinDatabase
import com.nezrin.coinsapp.data.model.CoinResponseById
import com.nezrin.coinsapp.data.model.CoinsResponse
import com.nezrin.coinsapp.domain.model.CoinsResponseItem
import com.nezrin.coinsapp.data.network.WebServiceApi
import com.nezrin.coinsapp.domain.repository.CoinsRepo
import retrofit2.Response
import javax.inject.Inject

class CoinsRepoImplementation  @Inject constructor(val api: WebServiceApi,val context: Context):CoinsRepo {

    private val db=CoinDatabase.getInstance(context).coinDao()

    override suspend fun getCoins(): Response<List<CoinsResponseItem>> {
        return api.getAllCoins()
    }

    override suspend fun getCoinById(id: String): Response<CoinResponseById> {
        return api.getCoinById(id)
    }

    override fun getCoinFromRoom(): LiveData<List<CoinsResponseItem>> {
        return db.getAllCoin()
    }

}