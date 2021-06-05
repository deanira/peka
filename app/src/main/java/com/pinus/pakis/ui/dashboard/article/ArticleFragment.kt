package com.pinus.pakis.ui.dashboard.article

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pakis.pinus.core.ui.ArticleRecyclerAdapter
import com.pakis.pinus.core.utils.ConnectivityReceiver
import com.pinus.pakis.databinding.FragmentArticleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : Fragment(), ConnectivityReceiver.ConnectivityReceiverListener {

    private val articleViewModel: ArticleViewModel by viewModels()
    private lateinit var articleAdapter: ArticleRecyclerAdapter
    private lateinit var binding: FragmentArticleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentArticleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadArticles()
    }

    private fun loadArticles() {
        isLoading(true)
        articleAdapter = ArticleRecyclerAdapter()
        articleViewModel.getArticles()
        articleViewModel.articles.observe(viewLifecycleOwner, {
            articleAdapter.setData(it)
            binding.rvArticles.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = this@ArticleFragment.articleAdapter
                setHasFixedSize(true)
            }
            isLoading(false)
        })
    }

    private fun isLoading(state: Boolean) {
        if (state) {
            binding.progressCircular.visibility = View.VISIBLE
            binding.tvNoInternet.visibility = View.VISIBLE
        } else {
            binding.progressCircular.visibility = View.INVISIBLE
            binding.tvNoInternet.visibility = View.INVISIBLE
        }
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        connectionChanged(isConnected)
    }

    private fun connectionChanged(isConnected: Boolean) {
        if (!isConnected) {
            isLoading(true)
            Snackbar.make(
                binding.root,
                "No Internet Connection",
                Snackbar.LENGTH_LONG
            ).show()
            binding.rvArticles.visibility = View.INVISIBLE
        } else {
            binding.rvArticles.visibility = View.VISIBLE
            isLoading(false)
            loadArticles()
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().registerReceiver(
            ConnectivityReceiver(),
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
        ConnectivityReceiver.connectivityReceiverListener = this
    }
}