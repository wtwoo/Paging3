package com.wtwoo.page3.data.repositories.movies

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava2.flowable
import com.wtwoo.page3.data.model.Movies
import com.wtwoo.page3.data.repositories.movies.MoviesPagingSource
import com.wtwoo.page3.data.repositories.movies.MoviesRepository
import io.reactivex.Flowable

class MoviesRepositoryImpl(private val pagingSource: MoviesPagingSource) :
    MoviesRepository {

    override fun getMovies(): Flowable<PagingData<Movies.Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = true,
                maxSize = 30,
                prefetchDistance = 5,
                initialLoadSize = 40
            ),
            pagingSourceFactory = { pagingSource }
        ).flowable
    }
}