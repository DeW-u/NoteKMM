package com.example.notekmm.di.modules

import com.example.notekmm.KoinSampleUC
import org.koin.dsl.module

val viewModelModule = module {
    single<KoinSampleUC> { KoinSampleUC() }
}