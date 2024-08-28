package com.zdy.myapplication.WebManager

import android.content.Context
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.zdy.myapplication.Fragments.HoursFragment

class WebManager {



    private val API_KEY = "c541682d629944e7b45153031242108"
    public val DAYS_COUNT = 3

    public fun GetWeather(city: String, context: Context ,callback: (result: String?) -> Unit){

        getResult(city,context,callback)

    }

    private fun getResult(name: String, context: Context , callback: (result: String?) -> Unit){

        val url = "https://api.weatherapi.com/v1/forecast.json?" +
                "key=$API_KEY" +
                "&q=$name" +
                "&days=$DAYS_COUNT" +
                "&aqi=no" +
                "&alerts=no"
        val queue = Volley.newRequestQueue(context)

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,{ response ->

                callback.invoke(response)

            },{error->

                callback.invoke(null)

            })

        queue.add(stringRequest)

    }



    companion object {

        @JvmStatic
        private fun newInstance() =
            WebManager()


        @Volatile
        private var instance: WebManager? = null
        public fun Instance() =
            instance ?: synchronized(this) {
                instance ?: WebManager().also { instance = it }
            }

    }

}