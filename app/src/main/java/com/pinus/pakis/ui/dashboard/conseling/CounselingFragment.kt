package com.pinus.pakis.ui.dashboard.conseling

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakis.pinus.core.ui.CounselingRecyclerAdapter
import com.pinus.pakis.databinding.FragmentConselingBinding

class CounselingFragment : Fragment() {

    private lateinit var binding: FragmentConselingBinding
    private val viewModel: CounselingViewModel by viewModels()
    private lateinit var counselingAdapter: CounselingRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConselingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("konseling", viewModel.dataCounseling.toString())
        loadCounseling()
    }

    private fun loadCounseling() {
        isLoading(true)
        counselingAdapter = CounselingRecyclerAdapter()
        counselingAdapter.setData(viewModel.dataCounseling)
        binding.rvCounseling.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = counselingAdapter
            setHasFixedSize(true)
        }
        isLoading(false)
    }

    private fun isLoading(state: Boolean) {
        if (state) {
            binding.progressCircular.visibility = View.VISIBLE
        } else {
            binding.progressCircular.visibility = View.INVISIBLE
        }
    }
}