package com.wtwoo.page3.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wtwoo.page3.R
import com.wtwoo.page3.data.model.Movies
import com.wtwoo.page3.databinding.MovieItemBinding

class MovieViewHolder(private val binding: MovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movies.Movie) {
        with(movie) {
            binding.movie = this
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false)
            val binding = MovieItemBinding.bind(view)
            return MovieViewHolder(binding)
        }
    }
}
