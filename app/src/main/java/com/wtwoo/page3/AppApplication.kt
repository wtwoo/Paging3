package com.wtwoo.page3

import android.app.Application
import com.wtwoo.page3.inject.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppApplication)
            fragmentFactory()
            modules(
                listOf(
                    fragmentModule,
                    viewModelModule,
                    repositoryModule,
                    apiManagerModule,
                    networkModule,
                )
            )
        }
    }
}