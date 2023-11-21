package com.example.notekmm.data

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.example.notekmm.NoteDatabase

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver = NativeSqliteDriver(NoteDatabase.Schema, "notes.db")
}