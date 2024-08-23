package com.zdy.myapplication.WebManager

import com.zdy.myapplication.DataClasses.DayWeather
import org.json.JSONObject

class WebParser {

    companion object{
        @JvmStatic
        public fun GetWeather(stringObj: String): DayWeather{

            val mainObject = JSONObject(stringObj)
            val locationObject = mainObject.getJSONObject("location")
            val currentObject = mainObject.getJSONObject("current")

            val item = DayWeather(
                locationObject.getString("name"),
                locationObject.getString("localtime"),
                currentObject.getJSONObject("condition").getString("text"),
                currentObject.getJSONObject("condition").getString("icon"),
                currentObject.getString("temp_c"),
                "-1",
                "+1",
                mainObject.getString("forecast"),

                )

            return item

        }
    }


}