package com.wtwoo.page3.ui.main

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.wtwoo.page3.R
import com.wtwoo.page3.adapter.LoadingStateAdapter
import com.wtwoo.page3.adapter.MoviesRxAdapter
import com.wtwoo.page3.base.BaseFragment
import com.wtwoo.page3.databinding.FragmentMainBinding
import com.wtwoo.page3.ext.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private lateinit var moviesAdapter: MoviesRxAdapter
    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAdapter()
    }

    private fun initView() {
        viewModel.items.observe(viewLifecycleOwner, { items ->
            moviesAdapter.submitData(lifecycle, items)
        })

        context?.toast(this, viewModel.toastMessage)

        viewModel.startFavoriteMovies()
    }


    private fun initAdapter() {
        moviesAdapter = MoviesRxAdapter()

        binding.list.apply {
            adapter = moviesAdapter
            adapter = moviesAdapter.withLoadStateFooter(footer = LoadingStateAdapter())
        }
        moviesAdapter.addLoadStateListener { loadState ->
            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error

            errorState?.let {
                activity?.showError(it.error.localizedMessage)
            }
        }
    }

    private fun Context.showError(message: String) {
        AlertDialog.Builder(this)
            .setTitle(R.string.error)
            .setMessage(message)
            .setNegativeButton(R.string.cancel) { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton(R.string.retry) { _, _ ->
                moviesAdapter.retry()
            }
            .show()
    }

    override fun onDestroy() {
        viewModel.close()
        super.onDestroy()
    }

}