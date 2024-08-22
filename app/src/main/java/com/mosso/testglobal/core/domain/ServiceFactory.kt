package com.mosso.testglobal.core.domain

interface ServiceFactory {
    fun <T> makeConnectionApiService(serviceClass: Class<T>): T
}