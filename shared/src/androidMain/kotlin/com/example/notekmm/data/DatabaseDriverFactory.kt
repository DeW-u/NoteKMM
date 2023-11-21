package com.example.notekmm.data

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.notekmm.NoteDatabase

actual class DatabaseDriverFactory (
    private val context: Context
) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(NoteDatabase.Schema, context, "notes.db")
}