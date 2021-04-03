package com.wtwoo.page3.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.rxjava2.cachedIn
import com.wtwoo.page3.data.repositories.movies.MoviesRepository
import com.wtwoo.page3.data.model.Movies
import io.reactivex.Flowable

class MainViewModel(private val repository: MoviesRepository) : ViewModel() {
    fun getFavoriteMovies(): Flowable<PagingData<Movies.Movie>> {
        return repository
            .getMovies()
            .map { pagingData -> pagingData.filter { it.poster != null } }
            .cachedIn(viewModelScope)
    }
}