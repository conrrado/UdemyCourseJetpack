package com.ccamacho.udemycoursejetpack.tasks

import com.ccamacho.udemycoursejetpack.models.Tasks
import com.ccamacho.udemycoursejetpack.models.Todo

class TasksModel {

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