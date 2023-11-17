package com.example.notekmm

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getViewModelModule(): Module = module {
    viewModel { SampleViewModel(get()) }
}