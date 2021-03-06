package com.polanski.airstatus.injections

import android.app.Application
import android.content.Context
import android.hardware.SensorManager
import com.polanski.airstatus.facades.PressureDisplay
import com.polanski.airstatus.facades.PressureDisplayImpl
import com.polanski.airstatus.providers.PressureProvider
import com.polanski.airstatus.providers.PressureProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AndroidModule(private val application: Application) {

    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideSensorManager(): SensorManager =
            application.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    @Provides
    @Singleton
    fun providePressureProvider(sensor: SensorManager): PressureProvider =
            PressureProviderImpl(sensor)

    @Provides
    @Singleton
    fun providePressureDisplay(provider: PressureProvider): PressureDisplay =
            PressureDisplayImpl(provider)
}
