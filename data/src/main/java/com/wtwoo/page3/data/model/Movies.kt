package com.wtwoo.page3.data.model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Movies(
    val total: Int = 0,
    val page: Int = 0,
    val movies: List<Movie>
) : Parcelable {

    @IgnoredOnParcel
    val endOfPage = total == page

    @Parcelize
    data class Movie(
        val id: Long = 0,
        val movieId: Long,
        val popularity: Double,
        val video: Boolean,
        val poster: Image?,
        val adult: Boolean,
        val backdrop: Image?,
        val originalLanguage: String,
        val originalTitle: String,
        val title: String,
        val voteAverage: Double,
        val overview: String,
        val releaseDate: Date?
    ) : Parcelable
}
