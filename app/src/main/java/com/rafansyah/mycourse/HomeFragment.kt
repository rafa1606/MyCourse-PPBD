package com.rafansyah.mycourse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(
            R.layout.fragment_home,
            container,
            false
        )

        val viewPager = requireActivity().findViewById<ViewPager2>(
            R.id.view_pager
        )

        val buttonMateri = view.findViewById<Button>(
            R.id.btn_materi
        )

        val buttonQuiz = view.findViewById<Button>(
            R.id.btn_quiz
        )

        buttonMateri.setOnClickListener {
            viewPager.currentItem = 1
        }

        buttonQuiz.setOnClickListener {
            viewPager.currentItem = 2
        }

        return view
    }
}