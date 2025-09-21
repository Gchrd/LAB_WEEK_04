package com.example.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView

class CafeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cafe_detail, container, false)

        val textView = view.findViewById<TextView>(R.id.cafe_detail_text)
        val position = arguments?.getInt("position") ?: 0
        textView.text = getString(TABS_FIXED[position])

        return view
    }
}
