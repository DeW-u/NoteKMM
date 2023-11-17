package com.example.notekmm.android

import android.app.Application
import com.example.notekmm.di.initKoin

class Application: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}