package com.wtwoo.page3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wtwoo.page3.ui.main.MainFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    private val mainFragment by inject<MainFragment> {
        parametersOf(null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            startMainFragment()
        }
    }

    private fun startMainFragment() {
        try {
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.container, mainFragment).commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}