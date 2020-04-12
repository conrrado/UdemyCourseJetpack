package com.ccamacho.udemycoursejetpack.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ccamacho.udemycoursejetpack.models.Notes

class NotesViewModal: ViewModel(), NotesListViewContract {

    private val model: NotesModel = NotesModel()

    private val _notesListLiveData: MutableLiveData<MutableList<Notes>> = MutableLiveData()
    val notesListLiveData: LiveData<MutableList<Notes>> = _notesListLiveData

    init {
        _notesListLiveData.postValue(model.getFakeData())
    }
}