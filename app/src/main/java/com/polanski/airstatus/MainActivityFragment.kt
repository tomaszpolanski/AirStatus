package com.polanski.airstatus

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import rx.lang.kotlin.observable
import rx.lang.kotlin.toSingletonObservable
import java.util.*

class MainActivityFragment : Fragment() {

    private var mSensorManager: SensorManager? = null

    private var mTextView: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mTextView = view!!.findViewById(R.id.pressure) as TextView

        mSensorManager = activity.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()

        mSensorManager!!.registerListener(mSensorListener, mSensorManager!!.getDefaultSensor(
                Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager!!.unregisterListener(mSensorListener)
    }

    private val mSensorListener = object : SensorEventListener {

        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
            // when accuracy changed, this method will be called.
        }

        override fun onSensorChanged(event: SensorEvent) {
            if (event.sensor.type == Sensor.TYPE_PRESSURE) {
                mTextView!!.text = "Air Pressure: " + event.values[0]
            }
        }
    }

}
