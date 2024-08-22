package com.mosso.testglobal.movies.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mosso.testglobal.core.presentation.ui.handlerErrorMessage
import com.mosso.testglobal.movies.presentation.components.Movie
import com.mosso.testglobal.movies.presentation.components.MySnackBar
import com.mosso.testglobal.movies.presentation.state.MovieUIState

@Composable
fun MovieListScreen(
    lazyListState: LazyListState,
    modifier: Modifier = Modifier,
    uiState: MovieUIState
) {
    when (uiState) {
        is MovieUIState.Error -> {
            MySnackBar(errorMessage = uiState.throwable.handlerErrorMessage())
        }
        MovieUIState.Loading -> ""
        is MovieUIState.Success -> {
            val moviesList = uiState.moviesList ?: arrayListOf()
            LazyColumn(state = lazyListState, modifier = modifier) {
                items(moviesList) { item ->
                    Movie(
                        urlImage = item.poster,
                        text = item.title,
                        titleMovie = item.title,
                        descriptionMovie = item.overview,
                        scoreMovie = item.votesAverage,
                    )
                }
            }
        }
    }
}