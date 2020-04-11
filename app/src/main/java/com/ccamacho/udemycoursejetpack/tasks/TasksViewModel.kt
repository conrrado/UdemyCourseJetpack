package com.ccamacho.udemycoursejetpack.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ccamacho.udemycoursejetpack.models.Tasks
import com.ccamacho.udemycoursejetpack.models.Todo

class TasksViewModel: ViewModel() {

    private val _tasksListLiveData: MutableLiveData<MutableList<Tasks>> = MutableLiveData()
    val tasksListLiveData: LiveData<MutableList<Tasks>> = _tasksListLiveData

    init {
        _tasksListLiveData.postValue(getFakeData())
    }

    fun getFakeData(): MutableList<Tasks> = mutableListOf(
        Tasks("Treinamento de Android", mutableListOf(
            Todo("Fundamentos e básico", true),
            Todo("Android e Jetpack")
        )),
        Tasks("Leitura", mutableListOf(
            Todo("Harry Potter e a pedra filosofal"),
            Todo("Percy Jackson e o mar de monstros")
        ))
    )
}