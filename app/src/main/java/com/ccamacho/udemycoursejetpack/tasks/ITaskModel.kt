package com.ccamacho.udemycoursejetpack.tasks

import com.ccamacho.udemycoursejetpack.models.Task

typealias SuccessCallback = (Boolean) -> Unit

interface ITaskModel {

    fun addTask(task: Task, callback: SuccessCallback)
    fun updateTask(task: Task, callback: SuccessCallback)
    fun deleteTask(task: Task, callback: SuccessCallback)
    fun retrieveTasks(): List<Task>

    fun getFakeData(): MutableList<Task>
}