package com.example.notekmm.feature_notes_list.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.notekmm.NoteDatabase
import com.example.notekmm.data.domain.NoteDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import schema.NoteEntity

class NotesListRepositoryImpl(
    private val database: NoteDatabase
) : NotesListRepository {

    override suspend fun insertNote(note: NoteDomain) = withContext(Dispatchers.Default) {
        database.noteQueries.insertNote(
            note.id,
            note.title,
            note.content,
            note.colorHex,
            note.created
        )
    }

    override fun observeNotes(): Flow<List<NoteDomain>> =
        database.noteQueries.getAllNotes().asFlow().mapToList(Dispatchers.Default).map { list -> list.map { note -> NoteDomain.mapFromDb(note) } }
}