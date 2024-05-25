package com.soha.infotech.androidmvvmtesting.utils

/**
 * Step5.1: Create a NetworkResult sealed class to handle UI states
 */

sealed class NetworkResult<T>(val data: T? = null, val message: String? = null) {

    class Success<T>(data: T) : NetworkResult<T>(data)
    class Error<T>(message: String?, data: T? = null) : NetworkResult<T>(data, message)
    class Loading<T> : NetworkResult<T>()

}