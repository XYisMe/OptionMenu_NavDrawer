package com.example.bottomnavview

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bottomnavview.fragments.GlobalStatisticsFragment
import com.example.bottomnavview.fragments.HomeFragment
import com.example.bottomnavview.fragments.MalaysiaStatisticsFragment

class ViewPagerAdapter(fa: HomeFragment?) : FragmentStateAdapter(fa!!){

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                MalaysiaStatisticsFragment.newInstance()
            }

            1 -> {
                GlobalStatisticsFragment.newInstance()
            }
            else -> MalaysiaStatisticsFragment.newInstance()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }

}