package com.pinus.pakis.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.pinus.pakis.databinding.ActivityIntroductoryBinding
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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