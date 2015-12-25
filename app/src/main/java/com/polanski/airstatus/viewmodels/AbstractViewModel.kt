package com.polanski.airstatus.viewmodels

import rx.subscriptions.CompositeSubscription

abstract class AbstractViewModel : ViewModel {

    private var subscriptions: CompositeSubscription? = null

    override fun dispose() {
        unsubscribeFromDataStore()
    }

    override fun subscribeToDataStore() {
        unsubscribeFromDataStore()
        val subscription = CompositeSubscription()
        subscribeToData(subscription)
        subscriptions = subscription
    }

    override fun unsubscribeFromDataStore() {
        subscriptions?.clear()
        subscriptions = null
    }

    protected abstract fun subscribeToData(subscription: CompositeSubscription)
}