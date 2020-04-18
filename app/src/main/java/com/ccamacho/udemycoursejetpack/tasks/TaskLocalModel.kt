package com.ccamacho.udemycoursejetpack.tasks

import com.ccamacho.udemycoursejetpack.application.NoteApplication
import com.ccamacho.udemycoursejetpack.database.RoomDatabaseClient
import com.ccamacho.udemycoursejetpack.models.Task
import com.ccamacho.udemycoursejetpack.models.Todo
import javax.inject.Inject

class TaskLocalModel @Inject constructor(): ITaskModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    override fun getFakeData(): MutableList<Task> = retrieveTasks()

    override fun addTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().addTask(task)
        addTodosInTask(task)
        callback.invoke(true)
    }

    private fun addTodosInTask(task: Task) {
        task.todos.forEach { todo ->
            databaseClient.taskDAO().addTodo(todo)
        }
    }

    override fun updateTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().updateTask(task)
        callback.invoke(true)
    }

    override fun updateTodo(todo: Todo, callback: SuccessCallback) {
        databaseClient.taskDAO().updateTodo(todo)
        callback.invoke(true)
    }

    override fun deleteTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().deleteTask(task)
        callback.invoke(true)
    }

    override fun retrieveTasks(): MutableList<Task> = databaseClient.taskDAO().retrieveTasks()
}