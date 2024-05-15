package com.scriptintech.unitconverterx.repository.unitrepos.time

import com.scriptintech.unitconverterx.repository.Result
import com.scriptintech.unitconverterx.repository.Unit
import com.scriptintech.unitconverterx.repository.UnitDefaults
import com.scriptintech.unitconverterx.repository.UnitResult
import java.util.Locale

class TimeImpl : UnitDefaults {
    override fun convertStringToDouble(input: String): Double {
        return input.toDoubleOrNull() ?: 0.0
    }

    override fun convertDoubleToString(input: Double): String {
        return String.format(Locale.ROOT, "%.2f", input)
    }

    override fun calculate(fromUnit: String, value: Double): UnitResult {
        return UnitResult(
            from = fromUnit,
            data = getConversionData(fromUnit, value),
        )
    }

    override fun getUnits(): List<Unit> {
        return listOf(
            Unit(key = "second", name = "Second"),
            Unit(key = "minute", name = "Minute"),
            Unit(key = "hour", name = "Hour"),
            Unit(key = "day", name = "Day"),
            Unit(key = "week", name = "Week"),
            Unit(key = "month", name = "Month"),
            Unit(key = "year", name = "Year")
        )
    }

    private fun getConversionData(fromUnit: String, value: Double): List<Result> {
        return when (fromUnit) {
            "second" -> listOf(
                Result("Second to Minute", "minute", convertDoubleToString(value / 60)),
                Result("Second to Hour", "hour", convertDoubleToString(value / 3600)),
                Result("Second to Day", "day", convertDoubleToString(value / 86400)),
                Result("Second to Week", "week", convertDoubleToString(value / 604800)),
                Result("Second to Month", "month", convertDoubleToString(value / 2.628e+6)),
                Result("Second to Year", "year", convertDoubleToString(value / 3.154e+7))
            )
            "minute" -> listOf(
                Result("Minute to Second", "second", convertDoubleToString(value * 60)),
                Result("Minute to Hour", "hour", convertDoubleToString(value / 60)),
                Result("Minute to Day", "day", convertDoubleToString(value / 1440)),
                Result("Minute to Week", "week", convertDoubleToString(value / 10080)),
                Result("Minute to Month", "month", convertDoubleToString(value / 43800)),
                Result("Minute to Year", "year", convertDoubleToString(value / 525600))
            )
            "hour" -> listOf(
                Result("Hour to Second", "second", convertDoubleToString(value * 3600)),
                Result("Hour to Minute", "minute", convertDoubleToString(value * 60)),
                Result("Hour to Day", "day", convertDoubleToString(value / 24)),
                Result("Hour to Week", "week", convertDoubleToString(value / 168)),
                Result("Hour to Month", "month", convertDoubleToString(value / 730)),
                Result("Hour to Year", "year", convertDoubleToString(value / 8760))
            )
            "day" -> listOf(
                Result("Day to Second", "second", convertDoubleToString(value * 86400)),
                Result("Day to Minute", "minute", convertDoubleToString(value * 1440)),
                Result("Day to Hour", "hour", convertDoubleToString(value * 24)),
                Result("Day to Week", "week", convertDoubleToString(value / 7)),
                Result("Day to Month", "month", convertDoubleToString(value / 30.417)),
                Result("Day to Year", "year", convertDoubleToString(value / 365))
            )
            "week" -> listOf(
                Result("Week to Second", "second", convertDoubleToString(value * 604800)),
                Result("Week to Minute", "minute", convertDoubleToString(value * 10080)),
                Result("Week to Hour", "hour", convertDoubleToString(value * 168)),
                Result("Week to Day", "day", convertDoubleToString(value * 7)),
                Result("Week to Month", "month", convertDoubleToString(value / 4.345)),
                Result("Week to Year", "year", convertDoubleToString(value / 52.143))
            )
            "month" -> listOf(
                Result("Month to Second", "second", convertDoubleToString(value * 2.628e+6)),
                Result("Month to Minute", "minute", convertDoubleToString(value * 43800)),
                Result("Month to Hour", "hour", convertDoubleToString(value * 730)),
                Result("Month to Day", "day", convertDoubleToString(value * 30.417)),
                Result("Month to Week", "week", convertDoubleToString(value * 4.345)),
                Result("Month to Year", "year", convertDoubleToString(value / 12))
            )
            "year" -> listOf(
                Result("Year to Second", "second", convertDoubleToString(value * 3.154e+7)),
                Result("Year to Minute", "minute", convertDoubleToString(value * 525600)),
                Result("Year to Hour", "hour", convertDoubleToString(value * 8760)),
                Result("Year to Day", "day", convertDoubleToString(value * 365)),
                Result("Year to Week", "week", convertDoubleToString(value * 52.143)),
                Result("Year to Month", "month", convertDoubleToString(value * 12))
            )
            else -> listOf(
                Result(title = "", unit = "", value = "")
            )
        }
    }
}
