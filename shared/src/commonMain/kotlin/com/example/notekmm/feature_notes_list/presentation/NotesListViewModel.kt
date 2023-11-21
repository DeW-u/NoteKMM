package com.example.notekmm.feature_notes_list.presentation

import com.example.notekmm.data.domain.NoteDomain
import com.example.notekmm.feature_notes_list.repository.NotesListRepository
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.launch

class NotesListViewModel(
    private val repo: NotesListRepository
): ViewModel() {

    val notesFlow = repo.observeNotes()

    fun insertNote(note: NoteDomain) = viewModelScope.launch {
        repo.insertNote(note)
    }
}