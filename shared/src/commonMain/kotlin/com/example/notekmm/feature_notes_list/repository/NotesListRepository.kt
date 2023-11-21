package com.example.notekmm.feature_notes_list.repository

import com.example.notekmm.data.domain.NoteDomain
import kotlinx.coroutines.flow.Flow

interface NotesListRepository {

    suspend fun insertNote(note: NoteDomain)

    fun observeNotes(): Flow<List<NoteDomain>>
}