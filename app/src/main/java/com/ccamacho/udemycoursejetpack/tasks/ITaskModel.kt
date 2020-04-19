package com.ccamacho.udemycoursejetpack.tasks

import com.ccamacho.udemycoursejetpack.models.Task
import com.ccamacho.udemycoursejetpack.models.Todo

typealias SuccessCallback = (Boolean) -> Unit

interface ITaskModel {

    suspend fun addTask(task: Task, callback: SuccessCallback)
    suspend fun updateTask(task: Task, callback: SuccessCallback)
    suspend fun updateTodo(todo: Todo, callback: SuccessCallback)
    suspend fun deleteTask(task: Task, callback: SuccessCallback)
    suspend fun retrieveTasks(callback: (MutableList<Task>?) -> Unit)
}