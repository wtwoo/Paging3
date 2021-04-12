package com.wtwoo.page3.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {
    val compositeDisposable by lazy { CompositeDisposable() }

    abstract fun close()

    override fun onCleared() {
        close()
        super.onCleared()
    }
}