package com.wtwoo.page3.ext

import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.wtwoo.page3.glide.GlideApp

fun ImageView.loadImage(url: Any?) {
    context?.let {
        GlideApp.with(this)
            .load(url)
            .apply(RequestOptions().transform(FitCenter()))
            .into(this)

    }
}