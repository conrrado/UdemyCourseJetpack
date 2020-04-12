package com.ccamacho.udemycoursejetpack.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ccamacho.udemycoursejetpack.foundations.ApplicationScope
import com.ccamacho.udemycoursejetpack.models.Note
import toothpick.Toothpick
import javax.inject.Inject

class NoteViewModal: ViewModel(), NoteListViewContract {

    @Inject
    lateinit var localModel: INoteModel

    private val _notesListLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()
    val notesListLiveData: LiveData<MutableList<Note>> = _notesListLiveData

    init {
        Toothpick.inject(this, ApplicationScope.scope)
        _notesListLiveData.postValue(localModel.getFakeData())
    }
}