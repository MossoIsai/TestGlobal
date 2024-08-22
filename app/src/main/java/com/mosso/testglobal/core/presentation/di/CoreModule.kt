package com.mosso.testglobal.core.presentation.di

import com.mosso.testglobal.BuildConfig
import com.mosso.testglobal.core.data.ApiServiceFactory
import com.mosso.testglobal.core.domain.ServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {

        val httpLoginInterceptor = HttpLoggingInterceptor()
        httpLoginInterceptor.level = HttpLoggingInterceptor.Level.BODY


        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_CONNECTION_HTTP, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_WRITE_HTTP, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_READ_HTTP, TimeUnit.SECONDS)
            .addInterceptor(httpLoginInterceptor).addInterceptor { chain ->
                val request =
                    chain.request().newBuilder()
                        .addHeader(
                            "Authorization",
                            "Bearer ${BuildConfig.MY_ACCESS_API_KEY}"
                        )
                        .build()
                chain.proceed(request)
            }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiServiceFactory(retrofit: Retrofit): ServiceFactory =
        ApiServiceFactory(retrofit)

    @IoDispatcher
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class IoDispatcher

    private const val BASE_URL = "https://api.themoviedb.org/"
    private const val TIMEOUT_READ_HTTP = 30L
    private const val TIMEOUT_WRITE_HTTP = 10L
    private const val TIMEOUT_CONNECTION_HTTP = 10L
}