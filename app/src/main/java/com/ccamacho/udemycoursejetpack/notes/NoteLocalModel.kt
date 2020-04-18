package com.ccamacho.udemycoursejetpack.notes

import android.util.Log
import com.ccamacho.udemycoursejetpack.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor(): INoteModel {

    override fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("Anotação 1", null),
        Note("Anotação 2", null),
        Note("Anotação 3", null)
    )

    override fun addNote(note: Note, callback: SuccessCallback) {
        Log.d("NoteLocalModel", note.toString())
        callback.invoke(true)
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