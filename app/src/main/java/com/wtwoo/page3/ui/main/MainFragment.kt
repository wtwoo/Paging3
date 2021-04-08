package com.wtwoo.page3.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.wtwoo.page3.R
import com.wtwoo.page3.adapter.LoadingGridStateAdapter
import com.wtwoo.page3.adapter.MoviesRxAdapter
import com.wtwoo.page3.base.BaseFragment
import com.wtwoo.page3.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.disposables.CompositeDisposable

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    private lateinit var adapter: MoviesRxAdapter
    private val compositeDisposable = CompositeDisposable()
    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        //binding.viewmodel = viewModel

        adapter = MoviesRxAdapter()

        binding.list.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.list.adapter = adapter
        binding.list.adapter = adapter.withLoadStateFooter(
            footer = LoadingGridStateAdapter()
        )
        adapter.addLoadStateListener { loadState ->
            val errorState = loadState.source.append as? LoadState.Error
                ?: loadState.source.prepend as? LoadState.Error
                ?: loadState.append as? LoadState.Error
                ?: loadState.prepend as? LoadState.Error

            errorState?.let {
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.error)
                    .setMessage(it.error.localizedMessage)
                    .setNegativeButton(R.string.cancel) { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setPositiveButton(R.string.retry) { _, _ ->
                        adapter.retry()
                    }
                    .show()
            }
        }

        compositeDisposable.add(viewModel.getFavoriteMovies().subscribe {
            adapter.submitData(lifecycle, it)
        })
    }

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}