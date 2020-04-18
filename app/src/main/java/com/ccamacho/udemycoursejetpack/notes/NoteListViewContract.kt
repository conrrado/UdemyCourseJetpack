package com.ccamacho.udemycoursejetpack.notes

import com.ccamacho.udemycoursejetpack.models.Note

interface NoteListViewContract {
    fun onDeleteNote(note: Note)
}