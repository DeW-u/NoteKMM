package com.example.notekmm.di.components

import com.example.notekmm.feature_notes_list.presentation.NotesListViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object ViewModelComponent: KoinComponent {
    fun getNotesListViewModel() = get<NotesListViewModel>()
}