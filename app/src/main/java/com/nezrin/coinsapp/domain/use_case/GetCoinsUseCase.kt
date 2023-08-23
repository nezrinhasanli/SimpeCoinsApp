package com.nezrin.coinsapp.domain.use_case

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.nezrin.coinsapp.common.Resource
import com.nezrin.coinsapp.domain.model.CoinsResponseItem
import com.nezrin.coinsapp.domain.repository.CoinsRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(var repo: CoinsRepo) {

//    private val _coinsLiveData=MutableLiveData<Resource<List<CoinsResponseItem>>>()
//    val coinsLiveData:LiveData<Resource<List<CoinsResponseItem>>> = _coinsLiveData
//    fun getCoins(){
//        CoroutineScope(IO).launch {
//            val response=repo.getCoins()
//            if (response.isSuccessful && response.code()==200){
//
//                _coinsLiveData.postValue(Resource.Success(response.body()!!))
//            }
//        }
//    }

    operator fun invoke() = liveData(IO) {
        emit(Resource.Loading) //postvalue yerine isledirik

        try {

            val response = repo.getCoins()
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