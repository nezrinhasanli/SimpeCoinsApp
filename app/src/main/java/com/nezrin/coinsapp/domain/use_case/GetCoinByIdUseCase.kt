package com.nezrin.coinsapp.domain.use_case

import androidx.lifecycle.liveData
import com.nezrin.coinsapp.common.Resource
import com.nezrin.coinsapp.domain.repository.CoinsRepo
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetCoinByIdUseCase @Inject constructor(var repo: CoinsRepo) {

    operator fun invoke(id:String) = liveData(Dispatchers.IO) {
        emit(Resource.Loading) //postvalue yerine isledirik

        try {

            val response = repo.getCoinById(id)
            if (response.isSuccessful && response.code() == 200) {
                emit(Resource.Success(response.body()!!)) //post value'nun qisa yolu
                return@liveData
            }
            if (response.code() == 401) {
                emit(Resource.Error(Exception("Illegal Request")))
                return@liveData
            }
        }catch (e:Exception){

            emit(Resource.Error(e))
        }
    }
}