package com.example.notekmm.data.domain

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import schema.NoteEntity

data class NoteDomain(
    val id: Long? = null,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: Long
) {
    companion object {
        fun mapFromDb(note: NoteEntity): NoteDomain = NoteDomain(
            note.id,
            note.title,
            note.content,
            note.colorHex,
            note.timestamp
        )
    }

    fun getDateTimeString(): String {
        val localDateTime = Instant.fromEpochMilliseconds(this.created).toLocalDateTime(TimeZone.currentSystemDefault())

        val date = localDateTime.date
        val day = date.dayOfMonth
        val month = date.monthNumber
        val year = date.year

        val time = localDateTime.time
        val hour = time.hour
        val minute = time.minute

        return buildString {
            append(day)
            append(".")
            append(month)
            append(".")
            append(year)
            append(" ")
            append(hour)
            append(":")
            append(minute)
        }
    }
}
