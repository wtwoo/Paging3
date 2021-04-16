package com.wtwoo.page3.adapter.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.wtwoo.page3.databinding.LoadingItemBinding

class LoadingStateViewHolder(
    private val binding: LoadingItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(loadState: LoadState) {
        binding.progressBar.isVisible = loadState is LoadState.Loading
    }

    companion object {
        fun from(parent: ViewGroup): LoadingStateViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = LoadingItemBinding.inflate(layoutInflater, parent, false)
            return LoadingStateViewHolder(binding)
        }
    }
}