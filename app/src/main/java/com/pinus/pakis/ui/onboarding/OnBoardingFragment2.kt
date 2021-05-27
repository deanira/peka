package com.pinus.pakis.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pinus.pakis.databinding.FragmentOnBoarding2Binding
import com.pinus.pakis.ui.auth.SignupSigninActivity

class OnBoardingFragment2 : Fragment() {

    private lateinit var binding: FragmentOnBoarding2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoarding2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSkip.setOnClickListener {
            val intent = Intent(context, SignupSigninActivity::class.java)
            startActivity(intent)
        }
    }
}