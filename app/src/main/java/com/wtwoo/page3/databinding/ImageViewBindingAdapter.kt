package com.wtwoo.page3.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.wtwoo.page3.ext.loadImage

@BindingAdapter("app:load")
fun setImageLoad(imageView: ImageView, path: Any?) {
    path?.let { imageView.loadImage(it) }
}