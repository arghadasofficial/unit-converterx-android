package com.scriptintech.unitconverterx.di

import com.scriptintech.unitconverterx.repository.area.AreaConverter
import com.scriptintech.unitconverterx.repository.area.AreaConverterImpl
import com.scriptintech.unitconverterx.repository.bmi.BmiCalculator
import com.scriptintech.unitconverterx.repository.bmi.BmiCalculatorImpl
import com.scriptintech.unitconverterx.repository.discount.DiscountCalculator
import com.scriptintech.unitconverterx.repository.discount.DiscountCalculatorImpl
import com.scriptintech.unitconverterx.repository.gst.GstCalculator
import com.scriptintech.unitconverterx.repository.gst.GstCalculatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
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

}