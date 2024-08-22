package com.mosso.testglobal.core.presentation.ui

import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

fun Throwable.handlerErrorMessage(): String {
    val errorMessage = when (this) {
        is HttpException -> StringConstants.HTTP_ERROR_EXCEPTION
        is SocketTimeoutException -> StringConstants.HTTP_ERROR_SOCKET_TIME_OUT
        is IOException -> StringConstants.HTTP_ERROR_IO_EXCEPTION
        else -> StringConstants.HTTP_ERROR_GENERIC
    }
    return errorMessage
}