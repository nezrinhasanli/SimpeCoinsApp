package com.nezrin.coinsapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nezrin.coinsapp.domain.model.CoinsResponseItem

@Database(entities = [CoinsResponseItem::class], version = 1)
abstract class CoinDatabase:RoomDatabase() {
    abstract fun coinDao():CoinDao

    companion object{
        @Volatile
        private var instance:CoinDatabase?=null

        fun getInstance(context: Context):CoinDatabase{
            return instance?: synchronized(this){
                instance?:Room.databaseBuilder(context.applicationContext,
                    CoinDatabase::class.java,
                    "coin_db").build()
            }
        }
    }
}