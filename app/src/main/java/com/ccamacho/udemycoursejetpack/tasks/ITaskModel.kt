package com.ccamacho.udemycoursejetpack.tasks

import com.ccamacho.udemycoursejetpack.models.Task
import com.ccamacho.udemycoursejetpack.models.Todo

typealias SuccessCallback = (Boolean) -> Unit

interface ITaskModel {

    fun addTask(task: Task, callback: SuccessCallback)
    fun updateTask(task: Task, callback: SuccessCallback)
    fun updateTodo(todo: Todo, callback: SuccessCallback)
    fun deleteTask(task: Task, callback: SuccessCallback)
    fun retrieveTasks(): MutableList<Task>

    fun getFakeData(): MutableList<Task>
}