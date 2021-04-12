package com.wtwoo.page3.ui.main

import androidx.annotation.StringRes
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.filter
import androidx.paging.rxjava2.cachedIn
import com.wtwoo.page3.Event
import com.wtwoo.page3.R
import com.wtwoo.page3.base.BaseViewModel
import com.wtwoo.page3.data.model.Movies
import com.wtwoo.page3.data.repositories.movies.MoviesRepository
import io.reactivex.Flowable

class MainViewModel @ViewModelInject constructor(private val repository: MoviesRepository) :
    BaseViewModel() {

    private val _toastMessage = MutableLiveData<Event<Int>>()
    val toastMessage: LiveData<Event<Int>> get() = _toastMessage

    private val _items = MutableLiveData<PagingData<Movies.Movie>>()
    val items: LiveData<PagingData<Movies.Movie>> = _items

    fun startFavoriteMovies() {
        favoriteMovies().subscribe({
            _items.value = it
        }, {
            showToastMessage(R.string.error)
        }).let { compositeDisposable.add(it) }
    }

    private fun favoriteMovies(): Flowable<PagingData<Movies.Movie>> {
        return repository
            .getMovies()
            .map { pagingData -> pagingData.filter { it.poster != null } }
            .cachedIn(viewModelScope)
    }

    private fun showToastMessage(@StringRes message: Int) {
        _toastMessage.value = Event(message)
    }

    override fun close() {
        compositeDisposable.clear()
    }
}