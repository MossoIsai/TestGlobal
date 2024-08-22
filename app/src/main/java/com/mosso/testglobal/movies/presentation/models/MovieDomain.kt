package com.mosso.testglobal.movies.presentation.models

import com.mosso.testglobal.movies.data.models.MovieData
import com.mosso.testglobal.movies.data.models.MovieResponseData

data class MovieDomain(
    val moviesList: List<MovieItem>
)

data class MovieItem(
    val title: String,
    val overview: String,
    val poster: String,
    val votesAverage: String,
)

fun MovieResponseData.toDomain(): MovieDomain = MovieDomain(
    moviesList = moviesList?.let { movies ->
        movies.flatMap {
            arrayListOf(it.toDomain())
        }
    } ?: arrayListOf()
)

fun MovieData.toDomain(): MovieItem = MovieItem(
    title = title ?: "",
    overview = overview ?: "",
    poster = poster ?: "",
    votesAverage = ""
)