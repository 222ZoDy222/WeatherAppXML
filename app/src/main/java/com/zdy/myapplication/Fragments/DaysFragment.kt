package com.zdy.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.zdy.myapplication.Adapters.HoursViewAdapter
import com.zdy.myapplication.MainViewModel
import com.zdy.myapplication.R
import com.zdy.myapplication.WebManager.WebParser
import com.zdy.myapplication.databinding.FragmentDaysBinding
import java.util.Calendar


class DaysFragment : Fragment() {


    private lateinit var binding : FragmentDaysBinding

    private lateinit var weatherAdapter: HoursViewAdapter

    private val model : MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDaysBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRC()
        AddListener()
    }

    private fun AddListener(){
        model.temperatureList.observe(viewLifecycleOwner){

            weatherAdapter.submitList(it.subList(1,it.size))
            hoursLayoutManager.scrollToPositionWithOffset(
                Calendar.getInstance().time.hours
                ,
                10)
        }
    }

    private lateinit var hoursLayoutManager:LinearLayoutManager
    private fun initRC() = with(binding){

        weatherAdapter = HoursViewAdapter()
        weatherAdapter.isHours = false
        rcView.adapter = weatherAdapter
        hoursLayoutManager = LinearLayoutManager(activity)
        rcView.layoutManager = hoursLayoutManager


    }

    companion object {

        @JvmStatic
        fun newInstance() =
            DaysFragment()
    }
}