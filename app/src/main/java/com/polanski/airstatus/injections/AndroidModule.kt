package com.polanski.airstatus.injections

import android.app.Application
import android.content.Context
import android.hardware.SensorManager
import com.polanski.airstatus.fasades.PressureDisplay
import com.polanski.airstatus.fasades.PressureDisplayImpl
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
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideSensorManager(): SensorManager {
        return application.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    @Provides
    @Singleton
    fun providePressureProvider(sensor: SensorManager): PressureProvider {
        return PressureProviderImpl(sensor);
    }

    @Provides
    @Singleton
    fun providePressureDisplay(provider: PressureProvider): PressureDisplay {
        return PressureDisplayImpl(provider);
    }
}
