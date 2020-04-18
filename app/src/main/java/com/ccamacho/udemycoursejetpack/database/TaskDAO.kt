package com.ccamacho.udemycoursejetpack.database

import androidx.room.*
import com.ccamacho.udemycoursejetpack.models.Task
import com.ccamacho.udemycoursejetpack.models.TaskEntity
import com.ccamacho.udemycoursejetpack.models.Todo

@Dao
interface TaskDAO {

    @Insert
    fun addTask(taskEntity: TaskEntity)

    @Insert
    fun addTodo(todo: Todo)

    @Update
    fun updateTask(taskEntity: TaskEntity)

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTask(taskEntity: TaskEntity)

    @Query("SELECT * FROM tasks")
    fun retrieveTasks(): MutableList<Task>
}