package com.zdy.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    // Header Temperature
    val selectedTemperature = MutableLiveData<String>()

    // List of the day temperature
    val temperatureList = MutableLiveData<String>()

}