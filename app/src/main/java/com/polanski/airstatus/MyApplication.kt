package com.polanski.airstatus

import android.app.Application
import com.polanski.airstatus.injections.AndroidModule
import com.polanski.airstatus.injections.ApplicationComponent
import com.polanski.airstatus.injections.DaggerApplicationComponent

public class MyApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit public var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder().androidModule(AndroidModule(this)).build()
        graph.inject(this)
    }
}
