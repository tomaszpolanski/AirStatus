package com.polanski.airstatus.facades

import com.polanski.airstatus.providers.PressureProvider
import rx.Observable

class PressureDisplayImpl(private val pressureDisplay: PressureProvider) : PressureDisplay {
    override fun pressureStream(): Observable<String> =
            pressureDisplay.pressureStream()
                    .map { "Current pressure: $it" }

}