package com.pinus.pakis.ui.dashboard.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakis.pinus.core.ui.ArticleRecyclerAdapter
import com.pinus.pakis.databinding.FragmentArticleBinding
import com.pinus.pakis.ui.dashboard.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleFragment : Fragment() {

    private val articleViewModel: ArticleViewModel by viewModels()
    private lateinit var articleAdapter: ArticleRecyclerAdapter
    private lateinit var binding: FragmentArticleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
        } else {
            binding.progressCircular.visibility = View.INVISIBLE
        }
    }
}