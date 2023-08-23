package com.nezrin.coinsapp.presentation.view.coin_detail

import androidx.lifecycle.ViewModel
import com.nezrin.coinsapp.data.model.CoinResponseById
import com.nezrin.coinsapp.domain.use_case.GetCoinByIdUseCase
import com.nezrin.coinsapp.domain.use_case.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class CoinDetailViewModel @Inject constructor(private val getCoinsByIdUseCase: GetCoinByIdUseCase):ViewModel() {

    fun getCoinById(id:String)= getCoinsByIdUseCase(id)
}