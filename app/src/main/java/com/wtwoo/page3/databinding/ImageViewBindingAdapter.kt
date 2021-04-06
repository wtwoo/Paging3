package com.wtwoo.page3.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("app:load")
fun setImageLoad(imageView: ImageView, path: Any?) {
    path?.let {
        imageView.load(it.toString()) {
            crossfade(true)
        }
    }
}