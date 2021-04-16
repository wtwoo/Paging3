package com.wtwoo.page3.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.wtwoo.page3.adapter.holder.LoadingStateViewHolder

class LoadingStateAdapter : LoadStateAdapter<LoadingStateViewHolder>() {
    override fun onBindViewHolder(holder: LoadingStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadingStateViewHolder {
        return LoadingStateViewHolder.from(parent)
    }
}