package com.ccamacho.udemycoursejetpack.notes

import com.ccamacho.udemycoursejetpack.models.Note

typealias SuccessCallback = (Boolean) -> Unit

interface INoteModel {

    suspend fun addNote(note: Note, callback: SuccessCallback)
    suspend fun updateNote(note: Note, callback: SuccessCallback)
    suspend fun deleteNote(note: Note, callback: SuccessCallback)
    suspend fun retrieveNotes(callback: (MutableList<Note>?) -> Unit)
}