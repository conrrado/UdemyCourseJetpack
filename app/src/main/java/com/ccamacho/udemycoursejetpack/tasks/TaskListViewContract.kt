package com.ccamacho.udemycoursejetpack.tasks

interface TaskListViewContract {
    fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean)
}