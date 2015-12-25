package com.polanski.airstatus.providers

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import rx.Observable
import rx.Subscriber
import rx.subscriptions.Subscriptions

class PressureProviderImpl(private val sensor: SensorManager) : PressureProvider {

    override fun pressureStream(): Observable<Float> {
        return Observable.create { sub ->
            if (!sub.isUnsubscribed) {
                val sensorListener = createListener(sub)
                registerPressure(sensorManager(), sensorListener)

                sub.add(Subscriptions.create { sensorManager().unregisterListener(sensorListener) })
            }
        }
    }

    private fun createListener(observer: Subscriber<in Float>): SensorEventListener {
        return object : SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            }

            override fun onSensorChanged(event: SensorEvent) {
                if ( !observer.isUnsubscribed &&
                        event.sensor.type == Sensor.TYPE_PRESSURE) {
                    observer.onNext(event.values[0])
                }
            }
        }
    }

    private fun sensorManager(): SensorManager = sensor

    private fun registerPressure(manager: SensorManager, listener: SensorEventListener) {
        manager.registerListener(listener, manager.getDefaultSensor(
                Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_NORMAL)
    }

}
