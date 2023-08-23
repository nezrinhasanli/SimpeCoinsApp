package com.nezrin.coinsapp.domain.use_case

import com.nezrin.coinsapp.domain.model.CoinsResponseItem
import com.nezrin.coinsapp.domain.repository.CoinsRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class InsertCoinUseCase(var repo: CoinsRepo) {
//    operator fun invoke(coin: CoinsResponseItem){
//
//        CoroutineScope(IO).launch{
//
//            repo.insertCoin(coin)
//        }
//    }
}