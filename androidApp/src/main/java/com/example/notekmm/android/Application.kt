package com.example.notekmm.android

import android.app.Application
import com.example.notekmm.di.initKoin
import org.koin.android.ext.koin.androidContext

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin().apply {
            androidContext(this@Application)
        }
    }
}