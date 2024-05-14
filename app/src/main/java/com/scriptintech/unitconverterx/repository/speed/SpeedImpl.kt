package com.scriptintech.unitconverterx.repository.speed

import com.scriptintech.unitconverterx.components.model.UDropdownModel
import com.scriptintech.unitconverterx.repository.ConverterDefault

class SpeedImpl : Speed, ConverterDefault {

    override fun convertStringToDouble(input: String): Double {
        return input.toDoubleOrNull() ?: 0.0
    }

    override fun getUnits(): List<UDropdownModel> {
        return listOf(
            UDropdownModel("mile_per_hour", "Mile Per Hour"),
            UDropdownModel("foot_per_second", "Foot Per Second"),
            UDropdownModel("meter_per_second", "Meter Per Second"),
            UDropdownModel("kilometer_per_hour", "Kilometer Per Hour"),
            UDropdownModel("knot", "Knot")
        )
    }

    override fun calculate(keyFrom: String, keyTo: String, value: Double): Double {
        return if (keyFrom == keyTo) {
            value
        } else {
            when (keyTo) {
                getUnits()[0].unit -> {
                    toMilePerHour(fromKey = keyFrom, value)
                }

                getUnits()[1].unit -> {
                    toFootPerSecond(fromKey = keyFrom, value)
                }

                getUnits()[2].unit -> {
                    toMeterPerSecond(fromKey = keyFrom, value)
                }

                getUnits()[3].unit -> {
                    toKilometerPerHour(fromKey = keyFrom, value)
                }

                getUnits()[4].unit -> {
                    toKnot(fromKey = keyFrom, value)
                }

                else -> 0.0
            }
        }
    }

    override fun toMilePerHour(fromKey: String, input: Double): Double {
        return when (fromKey) {
            "foot_per_second" -> {
                input / 1.467
            }

            "meter_per_second" -> {
                input * 2.237
            }

            "kilometer_per_hour" -> {
                input / 1.609
            }

            "knot" -> {
                input * 1.151
            }

            else -> 0.0
        }
    }

    override fun toKilometerPerHour(fromKey: String, input: Double): Double {
        return when (fromKey) {
            "mile_per_hour" -> {
                input * 1.609
            }

            "foot_per_second" -> {
                input * 1.097
            }

            "meter_per_second" -> {
                input * 3.6
            }

            "knot" -> {
                input * 1.852
            }

            else -> 0.0
        }
    }

    override fun toMeterPerSecond(fromKey: String, input: Double): Double {
        return when (fromKey) {
            "mile_per_hour" -> {
                input / 2.237
            }

            "foot_per_second" -> {
                input / 3.281
            }

            "kilometer_per_hour" -> {
                input / 3.6
            }

            "knot" -> {
                input / 1.944
            }

            else -> 0.0
        }
    }

    override fun toFootPerSecond(fromKey: String, input: Double): Double {
        return when (fromKey) {
            "mile_per_hour" -> {
                input * 1.467
            }

            "meter_per_second" -> {
                input * 3.281
            }

            "kilometer_per_hour" -> {
                input / 1.097
            }

            "knot" -> {
                input * 1.688
            }

            else -> 0.0
        }
    }

    override fun toKnot(fromKey: String, input: Double): Double {
        return when (fromKey) {
            "mile_per_hour" -> {
                input / 1.151
            }

            "foot_per_second" -> {
                input / 1.688
            }

            "meter_per_second" -> {
                input * 1.944
            }

            "kilometer_per_hour" -> {
                input / 1.852
            }

            else -> 0.0
        }
    }

}