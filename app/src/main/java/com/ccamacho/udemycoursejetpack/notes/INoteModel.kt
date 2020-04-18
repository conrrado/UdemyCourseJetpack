package com.ccamacho.udemycoursejetpack.notes

import com.ccamacho.udemycoursejetpack.models.Note

typealias SuccessCallback = (Boolean) -> Unit

interface INoteModel {

    fun addNote(note: Note, callback: SuccessCallback)
    fun updateNote(note: Note, callback: SuccessCallback)
    fun deleteNote(note: Note, callback: SuccessCallback)
    fun retrieveNotes(): MutableList<Note>

    fun getFakeData(): MutableList<Note>
}