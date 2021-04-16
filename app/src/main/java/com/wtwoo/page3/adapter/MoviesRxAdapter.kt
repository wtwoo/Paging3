package com.wtwoo.page3.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.wtwoo.page3.adapter.holder.MovieViewHolder
import com.wtwoo.page3.data.model.Movies

class MoviesRxAdapter : PagingDataAdapter<Movies.Movie, MovieViewHolder>(COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Movies.Movie>() {
            override fun areItemsTheSame(oldItem: Movies.Movie, newItem: Movies.Movie): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: Movies.Movie, newItem: Movies.Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}
