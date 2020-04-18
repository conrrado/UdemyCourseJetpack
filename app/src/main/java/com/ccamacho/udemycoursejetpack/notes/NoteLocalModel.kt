package com.ccamacho.udemycoursejetpack.notes

import android.util.Log
import com.ccamacho.udemycoursejetpack.application.NoteApplication
import com.ccamacho.udemycoursejetpack.database.RoomDatabaseClient
import com.ccamacho.udemycoursejetpack.models.Note
import javax.inject.Inject

class NoteLocalModel @Inject constructor(): INoteModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakeData(): MutableList<Note> = retrieveNotes()

    override fun addNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().addNote(note)
        callback.invoke(true)
    }

    override fun updateNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().updateNote(note)
        callback.invoke(true)
    }

    override fun deleteNote(note: Note, callback: SuccessCallback) {
        databaseClient.noteDAO().deleteNote(note)
        callback.invoke(true)
    }

    override fun retrieveNotes(): MutableList<Note> = databaseClient.noteDAO().retrieveNotes()
}