package com.ccamacho.udemycoursejetpack.tasks

import com.ccamacho.udemycoursejetpack.application.NoteApplication
import com.ccamacho.udemycoursejetpack.database.RoomDatabaseClient
import com.ccamacho.udemycoursejetpack.models.Task
import com.ccamacho.udemycoursejetpack.models.Todo
import kotlinx.coroutines.*
import java.lang.Exception
import javax.inject.Inject

const val TIMEOUT_DURATION_MILLS = 3000L

class TaskLocalModel @Inject constructor(): ITaskModel {

    private var databaseClient = RoomDatabaseClient.getInstance(NoteApplication.instance.applicationContext)

    private suspend fun performOperationWithTimeout(function: () -> Unit, callback: SuccessCallback) {
        val job = GlobalScope.async {
            try {
                withTimeout(TIMEOUT_DURATION_MILLS) {
                    function.invoke()
                }
            } catch (e: Exception) {
                callback.invoke(false)
            }
        }
        job.await()
        callback.invoke(true)
    }

    override suspend fun addTask(task: Task, callback: SuccessCallback) {
        val masterJob = GlobalScope.async {
            // adds task entity component
            try {
                databaseClient.taskDAO().addTask(task)
            } catch (e: Exception) {
                callback.invoke(false)
            }
            // adds todos list component
            addTodosJob(task)
        }
        masterJob.await()
        callback.invoke(true)
    }

    private fun addTodosJob(task: Task): Job = GlobalScope.async {
        task.todos.forEach { todo ->
            databaseClient.taskDAO().addTodo(todo)
        }
    }

    override suspend fun updateTask(task: Task, callback: SuccessCallback) {
        databaseClient.taskDAO().updateTask(task)
        callback.invoke(true)
    }

    override suspend fun updateTodo(todo: Todo, callback: SuccessCallback) {
        performOperationWithTimeout({ databaseClient.taskDAO().updateTodo(todo) }, callback)
    }

    override suspend fun deleteTask(task: Task, callback: SuccessCallback) {
        performOperationWithTimeout({ databaseClient.taskDAO().deleteTask(task) }, callback)
    }

    override suspend fun retrieveTasks(callback: (MutableList<Task>?) -> Unit) {
        GlobalScope.launch {
            val job = async {
                withTimeoutOrNull(TIMEOUT_DURATION_MILLS) {
                    databaseClient.taskDAO().retrieveTasks()
                }
            }
            callback.invoke(job.await())
        }
    }
}