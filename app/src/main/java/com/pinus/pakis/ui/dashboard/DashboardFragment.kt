package com.pinus.pakis.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakis.pinus.core.ui.ArticleRecyclerAdapter
import com.pakis.pinus.core.ui.VideoRecyclerAdapter
import com.pinus.pakis.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()
    private var _binding: FragmentDashboardBinding? = null
    private lateinit var videoAdapter: VideoRecyclerAdapter
    private lateinit var articleAdapter: ArticleRecyclerAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadVideos()
        loadArticles()
    }

    private fun loadVideos() {
        videoAdapter = VideoRecyclerAdapter()
        dashboardViewModel.getDummyVideos().observe(viewLifecycleOwner, {
            videoAdapter.setData(it)
            binding.rvVideo.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = this@DashboardFragment.videoAdapter
                setHasFixedSize(true)
            }
        })
    }

    private fun loadArticles() {
        articleAdapter = ArticleRecyclerAdapter()
        dashboardViewModel.getDummyArticles().observe(viewLifecycleOwner, {
            articleAdapter.setData(it)
            binding.rvArticles.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = this@DashboardFragment.articleAdapter
                setHasFixedSize(true)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}