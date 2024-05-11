package com.scriptintech.unitconverterx.screens.temperature

import androidx.lifecycle.ViewModel
import com.scriptintech.unitconverterx.repository.temperature.Temperature
import javax.inject.Inject

class TemperatureViewModel @Inject constructor(private val temperature: Temperature) : ViewModel() {

}