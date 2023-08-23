package com.nezrin.coinsapp.common
//bir funksiyadan 3 tip qaytaririq livedatanin icine 3 tip yerlesdiririk
sealed class Resource<out T : Any> {
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val exception: Throwable) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}