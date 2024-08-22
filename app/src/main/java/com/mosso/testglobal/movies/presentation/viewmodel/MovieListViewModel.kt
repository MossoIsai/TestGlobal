package com.mosso.testglobal.movies.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mosso.testglobal.movies.domain.usecase.GetMoviesUseCase
import com.mosso.testglobal.movies.presentation.state.MovieUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import com.mosso.testglobal.core.data.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class MovieListViewModel @Inject constructor(
    getMovieListUseCase: GetMoviesUseCase
) : ViewModel() {

    val movieUIState: StateFlow<MovieUIState> =
        getMovieListUseCase.execute().map {
            when (it) {
                is Result.Error -> MovieUIState.Error(it.exception)
                is Result.Success -> if (it.body?.isNotEmpty() == true) {
                    MovieUIState.Success(it.body)
                } else {
                    MovieUIState.Success(it.body)
                }
            }
        }.catch {
            MovieUIState.Error(it)
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = MovieUIState.Loading
        )

}