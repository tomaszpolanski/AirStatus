package com.polanski.airstatus.providers

import rx.Observable

interface PressureProvider {

    fun pressureStream(): Observable<Float>
}
