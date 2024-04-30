package com.scriptintech.unitconverterx.di

import com.scriptintech.unitconverterx.repository.bmi.BmiCalculator
import com.scriptintech.unitconverterx.repository.bmi.BmiCalculatorImpl
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
}