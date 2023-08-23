package com.nezrin.coinsapp.presentation.view.coin_list

import androidx.lifecycle.ViewModel
import com.nezrin.coinsapp.domain.model.CoinsResponseItem
import com.nezrin.coinsapp.domain.use_case.GetCoinsUseCase
import com.nezrin.coinsapp.domain.use_case.InsertCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase):ViewModel() {

    fun getCoins() = getCoinsUseCase()

//    fun insertCoins(coin: CoinsResponseItem) = insertCoinsUseCase(coin)
}