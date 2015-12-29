package com.polanski.airstatus.facades

import rx.Observable

interface PressureDisplay {
    fun pressureStream(): Observable<String>
}