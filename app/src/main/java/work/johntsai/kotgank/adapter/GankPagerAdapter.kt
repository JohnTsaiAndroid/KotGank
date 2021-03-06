package work.johntsai.kotgank.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import work.johntsai.kotgank.ui.GankDataFragment
import work.johntsai.kotgank.ui.MeiziFragment
import work.johntsai.kotgank.ui.VideoFragment

const val GANK_PAGER_NUMS: Int = 3

class GankPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> GankDataFragment()
            1 -> MeiziFragment()
            2 -> VideoFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return GANK_PAGER_NUMS
    }

}