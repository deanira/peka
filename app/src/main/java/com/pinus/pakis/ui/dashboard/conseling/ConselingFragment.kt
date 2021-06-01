package com.pinus.pakis.ui.dashboard.conseling

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pakis.pinus.core.ui.VideoRecyclerAdapter
import com.pinus.pakis.R
import com.pinus.pakis.databinding.FragmentConselingBinding
import com.pinus.pakis.databinding.ItemConselingBinding
import dagger.hilt.android.AndroidEntryPoint

class ConselingFragment : Fragment() {

    private lateinit var binding: FragmentConselingBinding
    private val viewModel : ConselingViewModel by viewModels()
    private lateinit var consellingAdapter: ConsellingRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConselingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        consellingAdapter = ConsellingRecyclerAdapter()
        consellingAdapter.setData(viewModel.dataConselling)
        binding.rvConseling.apply {
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = consellingAdapter
            setHasFixedSize(true)
        }
        viewModel.dataConselling.forEach {
            Log.e("kikoko" , it.name)
        }
    }

    private fun loadConselling() {
        consellingAdapter = ConsellingRecyclerAdapter()
        consellingAdapter.setData(viewModel.dataConselling)
        binding.rvConseling.apply {
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = consellingAdapter
            setHasFixedSize(true)
        }
    }
}