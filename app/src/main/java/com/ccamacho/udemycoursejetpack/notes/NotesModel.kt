package com.ccamacho.udemycoursejetpack.notes

import com.ccamacho.udemycoursejetpack.models.Notes

class NotesModel {

    fun getFakeData(): MutableList<Notes> = mutableListOf(
        Notes("Anotação 1", null),
        Notes("Anotação 2", null),
        Notes("Anotação 3", null)
    )
}