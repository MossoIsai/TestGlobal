package com.mosso.testglobal.movies.domain.repository

import com.mosso.testglobal.movies.data.models.MovieResponseData
import kotlinx.coroutines.flow.Flow
import com.mosso.testglobal.core.data.Result


interface GetMoviesRepository {
    suspend fun getMoviesList(): Flow<Result<MovieResponseData>>
}