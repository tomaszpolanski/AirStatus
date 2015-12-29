package com.polanski.airstatus.viewmodels

import com.polanski.airstatus.facades.PressureDisplay
import rx.Observable
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

class MainViewModel
@Inject
constructor(private val pressureDisplay: PressureDisplay) : AbstractViewModel() {

    override fun subscribeToData(subscription: CompositeSubscription) {

    }

    fun pressureStream(): Observable<String> = pressureDisplay.pressureStream()
}
