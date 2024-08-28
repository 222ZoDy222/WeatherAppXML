package com.zdy.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zdy.myapplication.DataClasses.DayWeather

class MainViewModel : ViewModel() {

    // Header Temperature
    val selectedTemperature = MutableLiveData<DayWeather>()

    // List of the day temperature
    val temperatureList = MutableLiveData<List<DayWeather>>()

    // Current Day Temperature
    val temperatureCurrent = MutableLiveData<DayWeather>()

}