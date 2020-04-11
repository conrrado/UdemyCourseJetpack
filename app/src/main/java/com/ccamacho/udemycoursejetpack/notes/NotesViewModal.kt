package com.ccamacho.udemycoursejetpack.notes

import androidx.lifecycle.ViewModel
import com.ccamacho.udemycoursejetpack.models.Notes

class NotesViewModal: ViewModel() {

    fun getFakeData(): MutableList<Notes> = mutableListOf(
        Notes("Anotação 1", null),
        Notes("Anotação 2", null),
        Notes("Anotação 3", null)
    )
}