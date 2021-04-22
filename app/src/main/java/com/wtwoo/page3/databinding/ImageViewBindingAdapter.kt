package com.wtwoo.page3.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.wtwoo.page3.data.model.Image

@BindingAdapter("app:load")
fun setImageLoad(imageView: ImageView, image: Image?) {
    image?.let {
        imageView.load(
            if (image.url.contains("http")) image.url
            else image.original.toString()
        ) {
            crossfade(true)
        }
    }
}