package com.ccamacho.udemycoursejetpack.notes

import com.ccamacho.udemycoursejetpack.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor(): INoteModel {

    override fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Anotação 1", null),
        Note("Anotação 2", null),
        Note("Anotação 3", null)
    )

    override fun addNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun retrieveNotes(): List<Note> {
        TODO("Not yet implemented")
    }
}