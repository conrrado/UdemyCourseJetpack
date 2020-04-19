package com.ccamacho.udemycoursejetpack

import com.ccamacho.udemycoursejetpack.models.Task
import com.ccamacho.udemycoursejetpack.models.Todo
import org.junit.Before
import org.junit.Test

class TaskTest {

    lateinit var testTask: Task

    @Before
    fun setUpBeforeTest() {
        testTask = getFakeTask()
    }

    @Test
    fun taskIsIncompleteOnInit() {
        assert(!testTask.isComplete())
    }

    @Test
    fun taskIsCompleteAfterAllTodosChecked() {
        testTask.todos.forEach {
            it.isComplete = true
        }
        assert(testTask.isComplete())
    }

    fun getFakeTask(): Task = Task(
        title = "Tarefa 1",
        todos = getFakeTodos()
    )

    fun getFakeTodos(): MutableList<Todo> = mutableListOf(
        Todo(description = "Item 1", isComplete = true),
        Todo(description = "Item 2"),
        Todo(description = "Item 3")
    )

}