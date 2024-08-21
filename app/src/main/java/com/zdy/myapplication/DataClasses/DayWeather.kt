package com.zdy.myapplication.DataClasses

data class DayWeather(
    val city: String,
    val time: String,
    val condition: String,
    val imageURL: String,
    val currentTemp: String,
    val minTemp : String,
    val maxTemp: String,
    val hours: String,

)
