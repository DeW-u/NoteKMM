package com.example.notekmm.di

import com.example.notekmm.di.modules.viewModelModule
import com.example.notekmm.getViewModelModule
import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(
        viewModelModule,
        getViewModelModule()
    )
}