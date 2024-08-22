package com.mosso.testglobal.movies.presentation

import com.mosso.testglobal.movies.data.repository.GetMoviesRepositoryImp
import com.mosso.testglobal.movies.domain.repository.GetMoviesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MovieModule {

    @Binds
    fun moviesRepository(moviesRepositoryImp: GetMoviesRepositoryImp): GetMoviesRepository
}