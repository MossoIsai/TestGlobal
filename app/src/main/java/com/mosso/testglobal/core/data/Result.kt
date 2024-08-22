package com.mosso.testglobal.core.data

sealed class Result<T> {
    data class Success<T>(val body:T?): Result<T>()
    data class Error<T>(val exception: Throwable): Result<T>()
}