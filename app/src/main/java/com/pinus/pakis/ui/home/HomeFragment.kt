package com.pinus.pakis.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.firebase.auth.FirebaseAuth
import com.pinus.pakis.databinding.FragmentHomeBinding
import com.pinus.pakis.ui.questions.QuestionActivity
import com.pinus.pakis.ui.result.ResultActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private lateinit var name: String

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        motivationView()
        populateView()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKuisioner.setOnClickListener {
            val intent = Intent(context, QuestionActivity::class.java)
            startActivity(intent)
        }
        binding.pullToRefresh.setOnRefreshListener {
            motivationView()
            populateView()
        }
    }

    private fun populateView() {
        name = FirebaseAuth.getInstance().currentUser?.displayName.toString()

        binding.textHome.text = name
        binding.pullToRefresh.isRefreshing = false
    }

    private fun motivationView() {


        homeViewModel.getRandomMotivation()
        homeViewModel.motivation.observe(viewLifecycleOwner, { item ->
            val stringMotivation = arrayListOf<String>()
            item.forEach {
                stringMotivation.add(it.item)
            }
            binding.tvDailyMotivation.text = stringMotivation.random()
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}