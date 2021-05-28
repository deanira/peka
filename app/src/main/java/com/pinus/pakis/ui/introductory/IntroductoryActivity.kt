package com.pinus.pakis.ui.introductory

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.pinus.pakis.databinding.ActivityIntroductoryBinding
import com.pinus.pakis.ui.main.MainActivity
import com.pinus.pakis.ui.onboarding.OnBoardingFragment1
import com.pinus.pakis.ui.onboarding.OnBoardingFragment2
import com.pinus.pakis.ui.onboarding.OnBoardingFragment3

class IntroductoryActivity : AppCompatActivity() {

    companion object {
        const val NUM_PAGES = 3
    }

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: ScreenSlidePagerAdapter
    private lateinit var binding: ActivityIntroductoryBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        if (auth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
        binding = ActivityIntroductoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        binding.pager.adapter = pagerAdapter

        supportActionBar?.hide()
    }

    private class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(
        fm,
        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    ) {
        override fun getCount(): Int = NUM_PAGES

        override fun getItem(position: Int): Fragment {
            var tab: Fragment? = null
            when (position) {
                0 -> {
                    tab = OnBoardingFragment1()
                    return tab
                }
                1 -> {
                    tab = OnBoardingFragment2()
                    return tab
                }
                2 -> {
                    tab = OnBoardingFragment3()
                    return tab
                }
            }
            return tab!!
        }
    }
}