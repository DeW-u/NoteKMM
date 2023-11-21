package com.example.notekmm.di

import com.example.notekmm.di.modules.databaseModule
import com.example.notekmm.di.modules.getDatabaseDriverFactoryModule
import com.example.notekmm.di.modules.getViewModelModule
import com.example.notekmm.di.modules.repositoryModule
import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(
        getDatabaseDriverFactoryModule(),
        databaseModule,
        repositoryModule,
        getViewModelModule()
    )
}