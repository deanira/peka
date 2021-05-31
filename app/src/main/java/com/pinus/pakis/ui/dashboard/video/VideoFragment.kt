package com.pinus.pakis.ui.dashboard.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakis.pinus.core.ui.VideoRecyclerAdapter
import com.pinus.pakis.databinding.FragmentVideoBinding
import com.pinus.pakis.ui.dashboard.DashboardViewModel

class VideoFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()
    private lateinit var videoAdapter: VideoRecyclerAdapter
    private lateinit var binding: FragmentVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentVideoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadVideos()
    }

    private fun loadVideos() {
        videoAdapter = VideoRecyclerAdapter()
        dashboardViewModel.getDummyVideos().observe(viewLifecycleOwner, {
            videoAdapter.setData(it)
            binding.rvVideo.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = this@VideoFragment.videoAdapter
                setHasFixedSize(true)
            }
        })
    }
}