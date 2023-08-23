package com.nezrin.coinsapp.data.network

import com.nezrin.coinsapp.data.model.CoinResponseById
import com.nezrin.coinsapp.data.model.CoinsResponse
import com.nezrin.coinsapp.domain.model.CoinsResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebServiceApi {
    @GET("v1/coins")
    suspend fun getAllCoins(): Response<List<CoinsResponseItem>>

    @GET("v1/coins/{id}")
    suspend fun getCoinById(@Path("id") id:String):Response<CoinResponseById>
}