package com.example.notekmm

import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.UIKit.UIDevice

actual fun getViewModelModule(): Module = module {
    single { SampleViewModel(get()) }
}

object ViewModels: KoinComponent {
    fun getSampleViewModel() = get<SampleViewModel>()
}