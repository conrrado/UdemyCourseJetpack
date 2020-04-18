package com.ccamacho.udemycoursejetpack.tasks

import android.util.Log
import com.ccamacho.udemycoursejetpack.models.Task
import com.ccamacho.udemycoursejetpack.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor(): ITaskModel {

    override fun getFakeData(): MutableList<Task> = mutableListOf(
        Task("Treinamento de Android", mutableListOf(
            Todo("Fundamentos e básico", true),
            Todo("Android e Jetpack")
        )),
        Task("Leitura", mutableListOf(
            Todo("Harry Potter e a pedra filosofal"),
            Todo("Percy Jackson e o mar de monstros")
        ))
    )

    override fun addTask(task: Task, callback: SuccessCallback) {
        Log.d("TaskLocalModel", task.toString())
        callback.invoke(true)
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        TODO("Not yet implemented")
    }

    override fun retrieveTasks(): List<Task> {
        TODO("Not yet implemented")
    }
}