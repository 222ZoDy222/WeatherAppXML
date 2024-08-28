package com.zdy.myapplication.DataClasses

data class DayWeather(
    val city: String,
    val time: String,
    val condition: String,
    val imageURL: String,
    val currentTemp: String,
    var minTemp : String,
    var maxTemp: String,
    var hours: String,

    )
