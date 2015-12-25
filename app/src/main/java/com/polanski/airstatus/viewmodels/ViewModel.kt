package com.polanski.airstatus.viewmodels

interface ViewModel {

    fun dispose()

    fun subscribeToDataStore()

    fun unsubscribeFromDataStore()
}