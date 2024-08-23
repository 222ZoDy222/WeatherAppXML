package com.zdy.myapplication.Fragments

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.tabs.TabLayoutMediator
import com.zdy.myapplication.Adapters.ViewPagerAdapter
import com.zdy.myapplication.R
import com.zdy.myapplication.WebManager.WebManager
import com.zdy.myapplication.WebManager.WebParser
import com.zdy.myapplication.databinding.ActivityMainBinding
import com.zdy.myapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() {


    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()

        InitAdapters()

        RequestWeather()
    }



    private fun RequestWeather(){
        WebManager.Instance()?.GetWeather("Penza",activity as Context){result->
            Log.i("RequestWebManagerLog", result ?: "null")
            result?.let {
                var day = WebParser.GetWeather(result)
                var t = 1
            }

        }
    }



    private val fragmentList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )
    private val tabList = listOf(
        "Hours",
        "Days"
    )
    private fun InitAdapters() = with(binding){
        viewPager.adapter = ViewPagerAdapter(activity as FragmentActivity,fragmentList)
        TabLayoutMediator(tabLayout,viewPager){tab,pos->

            tab.text = tabList[pos]

        }.attach()
    }

    private fun permissionListener(){
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ){permissionGranted ->
            Toast.makeText(activity,"Permission is $permissionGranted",Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkPermission(){
        if(!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)){
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}