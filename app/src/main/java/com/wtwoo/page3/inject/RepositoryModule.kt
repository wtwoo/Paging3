package com.wtwoo.page3.inject

import com.wtwoo.page3.data.repositories.movies.MoviesRepository
import com.wtwoo.page3.data.repositories.movies.MoviesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single { MoviesRepositoryImpl(get()) as MoviesRepository }
}