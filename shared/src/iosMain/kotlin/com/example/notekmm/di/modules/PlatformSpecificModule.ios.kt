package com.example.notekmm.di.modules

import app.cash.sqldelight.db.SqlDriver
import com.example.notekmm.data.DatabaseDriverFactory
import com.example.notekmm.feature_notes_list.presentation.NotesListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getViewModelModule(): Module = module {
    single { NotesListViewModel(get()) }
}

actual fun getDatabaseDriverFactoryModule(): Module = module {
    single { DatabaseDriverFactory().createDriver() }
}