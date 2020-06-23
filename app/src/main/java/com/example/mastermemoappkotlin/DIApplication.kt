package com.example.mastermemoappkotlin

import AppComponent
import android.app.Application

class DIApplication : Application()
{
    private var appComponent: AppComponent? = null

    override fun onCreate() {
        // initialisation :
        super.onCreate()
        instance = this

        // dagger :
        appComponent = DaggerAppComponent.builder().application(this)?.build()
    }

    companion object {
        // Attributs :
        private var instance: DIApplication? = null

        // Getter singleton :
        fun getAppComponent(): AppComponent? {
            return instance!!.appComponent
        }
    }
}
