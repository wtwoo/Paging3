package com.wtwoo.page3.data.repositories.movies

import androidx.paging.PagingData
import com.wtwoo.page3.data.model.Movies
import io.reactivex.Flowable

interface MoviesRepository {
    fun getMovies(): Flowable<PagingData<Movies.Movie>>
}