package com.polanski.airstatus

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.polanski.airstatus.providers.PressureProvider
import com.polanski.airstatus.providers.PressureProviderImpl

class MainActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view?.findViewById(R.id.pressure) as TextView

        val  pressure : PressureProvider = PressureProviderImpl(getActivity())
        pressure.pressureStream()
                .subscribe { textView.text = "Air Pressure!: " + it }
    }

}
