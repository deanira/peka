package com.pinus.pakis.ui.dashboard.video

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakis.pinus.core.ui.VideoRecyclerAdapter
import com.pinus.pakis.databinding.FragmentVideoBinding
import com.pinus.pakis.ui.dashboard.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : Fragment() {

    private val videoViewModel: VideoViewModel by viewModels()
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
        isLoading(true)
        videoAdapter = VideoRecyclerAdapter()
        videoViewModel.getVideos()
        videoViewModel.videos.observe(viewLifecycleOwner, {
            Log.d("DATA VIDEORESPONSE", it.toString())
            videoAdapter.setData(it)
            binding.rvVideo.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                adapter = this@VideoFragment.videoAdapter
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