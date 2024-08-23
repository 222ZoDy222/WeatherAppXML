package com.zdy.myapplication.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zdy.myapplication.Fragments.DaysFragment
import com.zdy.myapplication.Fragments.HoursFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity,
                       private val fragmentList: List<Fragment>): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }


}