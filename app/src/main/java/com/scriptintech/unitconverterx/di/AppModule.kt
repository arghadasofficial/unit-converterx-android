package com.scriptintech.unitconverterx.di

import com.scriptintech.unitconverterx.repository.unitrepos.area.AreaConverter
import com.scriptintech.unitconverterx.repository.unitrepos.area.AreaConverterImpl
import com.scriptintech.unitconverterx.repository.unitrepos.bmi.BmiCalculator
import com.scriptintech.unitconverterx.repository.unitrepos.bmi.BmiCalculatorImpl
import com.scriptintech.unitconverterx.repository.unitrepos.discount.DiscountCalculator
import com.scriptintech.unitconverterx.repository.unitrepos.discount.DiscountCalculatorImpl
import com.scriptintech.unitconverterx.repository.unitrepos.gst.GstCalculator
import com.scriptintech.unitconverterx.repository.unitrepos.gst.GstCalculatorImpl
import com.scriptintech.unitconverterx.repository.unitrepos.speed.SpeedImpl
import com.scriptintech.unitconverterx.repository.unitrepos.temperature.TemperatureImpl
import com.scriptintech.unitconverterx.repository.unitrepos.time.TimeImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBmiCalculator(): BmiCalculator {
        return BmiCalculatorImpl()
    }

    @Provides
    @Singleton
    fun provideAreaConverter(): AreaConverter {
        return AreaConverterImpl()
    }

    @Provides
    @Singleton
    fun provideDiscountCalculator(): DiscountCalculator {
        return DiscountCalculatorImpl()
    }

    @Provides
    @Singleton
    fun provideGstCalculator(): GstCalculator {
        return GstCalculatorImpl()
    }

    @Provides
    @Singleton
    fun provideTemperatureConverter(): TemperatureImpl {
        return TemperatureImpl()
    }

    @Provides
    @Singleton
    fun provideSpeedConverter(): SpeedImpl {
        return SpeedImpl()
    }

    @Provides
    @Singleton
    fun provideTimeConverter(): TimeImpl {
        return TimeImpl()
    }
}