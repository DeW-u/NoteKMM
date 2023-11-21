package com.example.notekmm.di.modules

import com.example.notekmm.feature_notes_list.repository.NotesListRepository
import com.example.notekmm.feature_notes_list.repository.NotesListRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<NotesListRepository> { NotesListRepositoryImpl(get()) }
}