package com.mosso.testglobal.movies.data.repository

import com.mosso.testglobal.core.domain.ServiceFactory
import com.mosso.testglobal.movies.data.models.MovieResponseData
import com.mosso.testglobal.movies.domain.repository.GetMoviesRepository
import kotlinx.coroutines.flow.Flow
import com.mosso.testglobal.core.data.Result
import com.mosso.testglobal.movies.data.service.MovieService
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesRepositoryImp @Inject constructor(
    private val serviceFactory: ServiceFactory
) : GetMoviesRepository {

    private val service = serviceFactory.makeConnectionApiService(MovieService::class.java)

    override suspend fun getMoviesList(): Flow<Result<MovieResponseData>> {
        return flow<Result<MovieResponseData>> {
            val response = service.getMovies()
            if (response.isSuccessful) {
                emit(Result.Success(response.body()))
            } else {
                emit(Result.Success(response.body()))
            }
        }.catch {
            emit(Result.Error(it))
        }
    }


}