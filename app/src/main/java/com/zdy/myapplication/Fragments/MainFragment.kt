package com.zdy.myapplication.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.zdy.myapplication.R
import com.zdy.myapplication.databinding.ActivityMainBinding
import com.zdy.myapplication.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding


    private val API_KEY = "c541682d629944e7b45153031242108"

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
        RequestWeather()
    }



    private fun RequestWeather(){
        getResult("Penza")
    }

    private fun getResult(name: String){

        val url = "https://api.weatherapi.com/v1/current.json?key=$API_KEY&q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this.context)

        val stringRequest = StringRequest(Request.Method.GET,
            url,{ response ->

                binding.AnswerText.text = response

            },{error->

                var t = 0
            })

        queue.add(stringRequest)

    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}