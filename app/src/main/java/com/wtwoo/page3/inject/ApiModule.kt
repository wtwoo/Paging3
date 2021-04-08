package com.wtwoo.page3.inject

import android.content.Context
import com.wtwoo.page3.R
import com.wtwoo.page3.data.mappers.MoviesMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Provides
    @Singleton
    @Named("apiKey")
    fun provideApiKey(
        @ApplicationContext context: Context
    ): String = context.getString(R.string.api_key)

    @Provides
    fun provideLocale(): Locale {
        return Locale.getDefault()
    }

    @Provides
    fun provideMoviesMapper(): MoviesMapper {
        return MoviesMapper()
    }
}