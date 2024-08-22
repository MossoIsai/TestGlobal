package com.mosso.testglobal.movies.data.service

import com.mosso.testglobal.movies.data.models.MovieResponseData
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("3/movie/popular?language=en-US&page=1")
    suspend fun getMovies(): Response<MovieResponseData>
}