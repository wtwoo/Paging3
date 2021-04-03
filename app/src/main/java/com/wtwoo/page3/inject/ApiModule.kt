package com.wtwoo.page3.inject

import com.wtwoo.page3.R
import com.wtwoo.page3.data.repositories.TMDBService
import com.wtwoo.page3.data.repositories.movies.MoviesPagingSource
import com.wtwoo.page3.data.mappers.MoviesMapper
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.*

val apiManagerModule: Module = module {
    single {
        MoviesPagingSource(
            service = (get() as Retrofit).create(TMDBService::class.java),
            apiKey = androidApplication().getString(R.string.api_key),
            mapper = MoviesMapper(),
            locale = Locale.getDefault()
        )
    }
}