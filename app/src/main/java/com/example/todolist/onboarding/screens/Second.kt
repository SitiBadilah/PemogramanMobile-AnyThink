package com.example.todolist.onboarding.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todolist.R

class Second : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_welcomeActivity)
        }

        return view
    }

}