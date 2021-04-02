package com.wtwoo.page3

import android.app.Application
import timber.log.Timber

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

}