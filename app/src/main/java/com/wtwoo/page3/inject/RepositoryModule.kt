package com.wtwoo.page3.inject

import com.wtwoo.page3.data.repositories.movies.MoviesPagingSource
import com.wtwoo.page3.data.repositories.movies.MoviesRepository
import com.wtwoo.page3.data.repositories.movies.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {
    @Provides
    @ActivityRetainedScoped
    fun provideRepository(moviesPagingSource: MoviesPagingSource): MoviesRepository {
        return MoviesRepositoryImpl(moviesPagingSource)
    }
}