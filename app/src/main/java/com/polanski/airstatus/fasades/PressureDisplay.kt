package com.polanski.airstatus.fasades

import rx.Observable

interface PressureDisplay {
    fun pressureStream(): Observable<String>
}