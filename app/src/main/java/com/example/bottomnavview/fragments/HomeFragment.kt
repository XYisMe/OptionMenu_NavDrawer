package com.example.bottomnavview.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.bottomnavview.R
import com.example.bottomnavview.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private var pagerAdapter:FragmentStateAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_home, container, false)

        val tab_layout = view.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager2)

        //adapt the viewpager using the vpAdapter
        pagerAdapter = ViewPagerAdapter(this)

        //set adapter
        viewPager.setAdapter(pagerAdapter)

        val titles = arrayOf("Malaysia", "Global")
        //display tab and mediate the tab layout with the view pager2
        TabLayoutMediator(tab_layout, viewPager) {
            tab: TabLayout.Tab, position: Int ->
                tab.text = titles[position]
        }.attach()
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}