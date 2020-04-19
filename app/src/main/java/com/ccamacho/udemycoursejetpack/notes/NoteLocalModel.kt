package com.ccamacho.udemycoursejetpack.notes

import com.ccamacho.udemycoursejetpack.application.NoteApplication
import com.ccamacho.udemycoursejetpack.database.RoomDatabaseClient
import com.ccamacho.udemycoursejetpack.models.Note
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject

const val TIMEOUT_DURATION_MILLS = 3000L

class NoteLocalModel @Inject constructor(): INoteModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    private suspend fun performOperationWithTimeout(function: () -> Unit, callback: SuccessCallback) {
        val job = GlobalScope.async {
            try {
                withTimeout(TIMEOUT_DURATION_MILLS) {
                    function.invoke()
                }
            } catch (e: Exception) {
                callback.invoke(false)
            }
        }
        job.await()
        callback.invoke(true)
    }

    override suspend fun addNote(note: Note, callback: SuccessCallback) {
        performOperationWithTimeout({ databaseClient.noteDAO().addNote(note) }, callback)
    }

    override suspend fun updateNote(note: Note, callback: SuccessCallback) {
        performOperationWithTimeout({ databaseClient.noteDAO().updateNote(note) }, callback)
    }

    override suspend fun deleteNote(note: Note, callback: SuccessCallback) {
        performOperationWithTimeout({ databaseClient.noteDAO().deleteNote(note) }, callback)
    }

    override suspend fun retrieveNotes(callback: (MutableList<Note>?) -> Unit) {
        val job = GlobalScope.async {
            withTimeoutOrNull(TIMEOUT_DURATION_MILLS) {
                databaseClient.noteDAO().retrieveNotes()
            }
        }
        callback.invoke(job.await())
    }
}