package com.zdy.myapplication.WebManager

import com.zdy.myapplication.DataClasses.DayWeather
import org.json.JSONArray
import org.json.JSONObject

class WebParser {

    data class ParseRequest(val currentDay: DayWeather, val daysWeather: List<DayWeather>)

    companion object{
        @JvmStatic
        public fun GetWeather(stringObj: String): ParseRequest{

            val mainObject = JSONObject(stringObj)

            var currentWeather = ParseCurrent(mainObject)

            val daysWeather = ParseDays(mainObject)

            currentWeather.minTemp = daysWeather[0].minTemp
            currentWeather.maxTemp = daysWeather[0].maxTemp
            currentWeather.hours = daysWeather[0].hours

            return ParseRequest(currentWeather,daysWeather)

        }


        @JvmStatic
        public fun ParseCurrent(mainObject: JSONObject): DayWeather{

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
                "",

                )

            return item
        }

        @JvmStatic
        public fun ParseDays(mainObject: JSONObject): List<DayWeather>{

            var daysList = ArrayList<DayWeather>()

            val daysArray = mainObject.getJSONObject("forecast").getJSONArray("forecastday")

            val locationObject = mainObject.getJSONObject("location")


            for (i in 0 until daysArray.length()){

                val forecastDayJson : JSONObject = daysArray[i] as JSONObject
                val dayObject = forecastDayJson.getJSONObject("day")
                val item = DayWeather(
                    locationObject.getString("name"),
                    forecastDayJson.getString("date"),
                    dayObject.getJSONObject("condition").getString("text"),
                    dayObject.getJSONObject("condition").getString("icon"),
                    "",
                    dayObject.getString("mintemp_c"),
                    dayObject.getString("maxtemp_c"),
                    forecastDayJson.getJSONArray("hour").toString(),

                    )
                daysList.add(item)

            }

            return daysList

        }


        @JvmStatic
        public fun GetHours(day: DayWeather) : List<DayWeather>{
            val hoursArray  = JSONArray(day.hours)
            val result = arrayListOf<DayWeather>()
            for (i in 0 until hoursArray.length()){
                val jsonHour = hoursArray[i] as JSONObject
                val item = DayWeather(
                    day.city,
                    jsonHour.getString("time"),
                    jsonHour.getJSONObject("condition").getString("text"),
                    jsonHour.getJSONObject("condition").getString("icon"),
                    jsonHour.getString("temp_c"),
                    "","",""
                )
                result.add(item)

            }

            return result

        }

    }


}