package com.wtwoo.page3.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.wtwoo.page3.R
import com.wtwoo.page3.databinding.LoadingGridItemBinding

class LoadingGridStateViewHolder(
    private val binding: LoadingGridItemBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(loadState: LoadState) {
        binding.progressBar.isVisible = loadState is LoadState.Loading
    }

    companion object {
        fun create(parent: ViewGroup): LoadingGridStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.loading_grid_item, parent, false)

            val binding = LoadingGridItemBinding.bind(view)

            return LoadingGridStateViewHolder(
                binding
            )
        }
    }
}