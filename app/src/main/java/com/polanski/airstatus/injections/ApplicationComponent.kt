package com.polanski.airstatus.injections

import com.polanski.airstatus.MainActivity
import com.polanski.airstatus.MainActivityFragment
import com.polanski.airstatus.MyApplication

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface ApplicationComponent {
    fun inject(application: MyApplication)

    fun inject(mainActivity: MainActivity)

    fun inject(fragment: MainActivityFragment)
}
