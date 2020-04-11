package com.ccamacho.udemycoursejetpack.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ccamacho.udemycoursejetpack.models.Notes

class NotesViewModal: ViewModel() {

    private val _notesListLiveData: MutableLiveData<MutableList<Notes>> = MutableLiveData()
    val notesListLiveData: LiveData<MutableList<Notes>> = _notesListLiveData

    init {
        _notesListLiveData.postValue(getFakeData())
    }

    fun getFakeData(): MutableList<Notes> = mutableListOf(
        Notes("Anotação 1", null),
        Notes("Anotação 2", null),
        Notes("Anotação 3", null)
    )
}