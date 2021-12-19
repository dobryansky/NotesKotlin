package com.artem.noteskotlin.data

object DataBase {

    var notes: List<Note> = emptyList()
        private set


    fun addNote(note: Note) {
        notes = notes + listOf(note)
    }

    fun clear() {
        notes = emptyList()
    }

}