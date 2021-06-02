package com.pinus.pakis.ui.dashboard

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pinus.pakis.R
import com.pinus.pakis.ui.dashboard.article.ArticleFragment
import com.pinus.pakis.ui.dashboard.conseling.CounselingFragment
import com.pinus.pakis.ui.dashboard.video.VideoFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.video, R.string.articles, R.string.conseling)
    }

    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> VideoFragment()
            1 -> ArticleFragment()
            2 -> CounselingFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence =
        mContext.resources.getString(TAB_TITLES[position])
}