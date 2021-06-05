package com.pinus.pakis.ui.dashboard.video

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pakis.pinus.core.ui.VideoRecyclerAdapter
import com.pakis.pinus.core.utils.ConnectivityReceiver
import com.pinus.pakis.databinding.FragmentVideoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment : Fragment(), ConnectivityReceiver.ConnectivityReceiverListener {

    private val videoViewModel: VideoViewModel by viewModels()
    private lateinit var videoAdapter: VideoRecyclerAdapter
    private lateinit var binding: FragmentVideoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
            binding.rvVideo.visibility = View.INVISIBLE
        } else {
            binding.rvVideo.visibility = View.VISIBLE
            isLoading(false)
            loadVideos()
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