package com.pinus.pakis.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pinus.pakis.databinding.FragmentOnBoarding1Binding

class OnBoardingFragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOnBoarding1Binding.inflate(inflater, container, false)
        return binding.root
    }
}