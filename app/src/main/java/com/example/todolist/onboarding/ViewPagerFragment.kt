package com.example.todolist.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.todolist.onboarding.ViewPagerAdapter
import com.example.todolist.onboarding.screens.First
import com.example.todolist.onboarding.screens.Second
import com.example.todolist.R

class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            First(),
            Second()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        val viewpager=view.findViewById<ViewPager2>(R.id.viewpager)

        viewpager.adapter=adapter

        return view
    }

}