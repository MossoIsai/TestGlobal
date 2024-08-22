package com.mosso.testglobal.movies.data.models

import com.google.gson.annotations.SerializedName

data class MovieResponseData(
    @SerializedName("results") val moviesList: List<MovieData>?
)

data class MovieData(
    val adult: Boolean = false,
    @SerializedName("backdrop_path") val backdrop: String?,
    @SerializedName("genre_ids") val genreIds: List<Int>?,
    val id: Int?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("original_title") val originalTitle: String?,
    val overview: String?,
    val popularity: String?,
    @SerializedName("poster_path") val poster: String?,
    @SerializedName("release_date") val releaseDate: String?,
    val title: String?,
    val video: Boolean = false,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: Int?
)