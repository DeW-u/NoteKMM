package com.example.notekmm.di.modules

import com.example.notekmm.NoteDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<NoteDatabase> { NoteDatabase(get()) }
}