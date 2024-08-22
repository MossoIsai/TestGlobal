package com.mosso.testglobal.movies.domain.usecase

import com.mosso.testglobal.core.domain.usecase.BaseUseCase
import com.mosso.testglobal.movies.domain.repository.GetMoviesRepository
import com.mosso.testglobal.movies.presentation.models.MovieItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import com.mosso.testglobal.core.data.Result
import kotlinx.coroutines.CoroutineDispatcher
import com.mosso.testglobal.core.presentation.di.CoreModule.IoDispatcher
import com.mosso.testglobal.movies.presentation.models.toDomain


class GetMoviesUseCase @Inject constructor(
    private val repository: GetMoviesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : BaseUseCase<Unit, Result<List<MovieItem>>>() {
    override fun execute(params: Unit): Flow<Result<List<MovieItem>>> =
        flow<Result<List<MovieItem>>> {
            repository.getMoviesList().collect {
                when (it) {
                    is Result.Error -> emit(Result.Error(it.exception))
                    is Result.Success -> emit(Result.Success(it.body?.toDomain()?.moviesList))
                }
            }
        }.flowOn(dispatcher)
}