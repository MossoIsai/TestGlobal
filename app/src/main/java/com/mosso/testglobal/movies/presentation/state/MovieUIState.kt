package com.mosso.testglobal.movies.presentation.state

import com.mosso.testglobal.movies.presentation.models.MovieItem

sealed interface MovieUIState {
    data object Loading : MovieUIState
    data class Error(val throwable: Throwable) : MovieUIState

    data class Success(val moviesList: List<MovieItem>?) : MovieUIState
}