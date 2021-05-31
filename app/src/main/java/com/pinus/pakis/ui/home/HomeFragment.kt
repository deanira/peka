package com.pinus.pakis.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.pinus.pakis.databinding.FragmentHomeBinding
import com.pinus.pakis.ui.questions.QuestionActivity
import com.pinus.pakis.ui.result.ResultActivity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var name: String

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        populateView()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnKuisioner.setOnClickListener {
            val intent = Intent(context, ResultActivity::class.java)
            startActivity(intent)
        }
        binding.pullToRefresh.setOnRefreshListener {
            populateView()
        }
    }

    private fun populateView() {
        name = FirebaseAuth.getInstance().currentUser?.displayName.toString()

        binding.textHome.text = name
        binding.pullToRefresh.isRefreshing = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}