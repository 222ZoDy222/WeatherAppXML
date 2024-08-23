package com.zdy.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zdy.myapplication.Adapters.HoursViewAdapter
import com.zdy.myapplication.DataClasses.DayWeather
import com.zdy.myapplication.R
import com.zdy.myapplication.databinding.FragmentHoursBinding


class HoursFragment : Fragment() {


    private lateinit var binding : FragmentHoursBinding

    private lateinit var weatherAdapter: HoursViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHoursBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRC()

    }

    private fun initRC() = with(binding){


        weatherAdapter = HoursViewAdapter()
        rcView.adapter = weatherAdapter
        rcView.layoutManager = LinearLayoutManager(activity)

        val list = listOf<DayWeather>(
            DayWeather(time="22:30", currentTemp = "24", city = "", condition = "", imageURL = "", minTemp = "", maxTemp = "", hours = ""),
            DayWeather(time="23:30", currentTemp = "25", city = "", condition = "", imageURL = "", minTemp = "", maxTemp = "", hours = ""),
            DayWeather(time="00:30", currentTemp = "26", city = "", condition = "", imageURL = "", minTemp = "", maxTemp = "", hours = ""),
        )

        weatherAdapter.submitList(list)

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HoursFragment()
    }
}