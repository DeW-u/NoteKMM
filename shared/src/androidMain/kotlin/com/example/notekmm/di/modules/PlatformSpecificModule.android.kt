package com.example.notekmm.di.modules

import app.cash.sqldelight.db.SqlDriver
import com.example.notekmm.data.DatabaseDriverFactory
import com.example.notekmm.feature_notes_list.presentation.NotesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getViewModelModule(): Module = module {
    viewModel { NotesListViewModel(get()) }
}

actual fun getDatabaseDriverFactoryModule(): Module = module {
    single<SqlDriver> { DatabaseDriverFactory(get()).createDriver() }
}