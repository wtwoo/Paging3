package com.wtwoo.page3.data.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(val url: String) : Parcelable {

    @IgnoredOnParcel
    val original: Uri = Uri.parse("$PATH/original/$url")

    companion object {
        private const val PATH = "https://image.tmdb.org/t/p"
    }

}
