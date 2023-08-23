package com.nezrin.coinsapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nezrin.coinsapp.domain.model.CoinsResponseItem

@Dao
interface CoinDao {

   @Query("SELECT * FROM coin")
   fun getAllCoin():LiveData<List<CoinsResponseItem>>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertCoin(coin:List<CoinsResponseItem>)

   @Delete
   suspend fun deleteCoin(coin:CoinsResponseItem)
}