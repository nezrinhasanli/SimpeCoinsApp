package com.nezrin.coinsapp.di

import android.app.Application
import android.content.Context
import com.nezrin.coinsapp.common.Constant
import com.nezrin.coinsapp.data.network.WebServiceApi
import com.nezrin.coinsapp.data.repository.CoinsRepoImplementation
import com.nezrin.coinsapp.domain.repository.CoinsRepo
import com.nezrin.coinsapp.domain.use_case.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

    @Module
    @InstallIn(SingletonComponent::class)
    class ModuleApp {

        @Provides
        @Singleton
        fun provideRepo(coinsRepositoryImpl: CoinsRepoImplementation):CoinsRepo{
            return coinsRepositoryImpl
        }

        @Provides
        @Singleton
        fun provideGetCoinUseCase(coinsRepository: CoinsRepo): GetCoinsUseCase {
            return GetCoinsUseCase(coinsRepository)
        }

        @Provides
        @Singleton
        fun provideApi(retrofit: Retrofit):WebServiceApi{
            return retrofit.create(WebServiceApi::class.java)
        }

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val clientBuilder = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

            return Retrofit.Builder()
                .baseUrl(Constant.base_url)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(clientBuilder)
                .build()
        }

        @Provides
        @Singleton
        fun provideContext(application: Application): Context {
            return application.applicationContext
        }

    }