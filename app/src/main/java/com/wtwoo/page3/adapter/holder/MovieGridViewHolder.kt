package com.wtwoo.page3.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wtwoo.page3.R
import com.wtwoo.page3.data.model.Movies
import com.wtwoo.page3.databinding.MovieGridItemBinding

class MovieGridViewHolder(private val binding: MovieGridItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movies.Movie) {
        with(movie) {
            binding.movie = this
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieGridViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_grid_item, parent, false)
            val binding = MovieGridItemBinding.bind(view)
            return MovieGridViewHolder(binding)
        }
    }
}
