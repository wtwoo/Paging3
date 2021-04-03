package com.wtwoo.page3.inject

import com.wtwoo.page3.ui.main.MainFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val fragmentModule = module {
    fragment { MainFragment() }
}