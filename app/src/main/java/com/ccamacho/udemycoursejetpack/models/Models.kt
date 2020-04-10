package com.ccamacho.udemycoursejetpack.models

data class Tasks(
    var title: String,
    val todos: MutableList<Todo> = mutableListOf(),
    var tag: Tag? = null
)

data class Todo(
    var description: String,
    var isComplete: Boolean
)

data class Notes(
    var description: String,
    var tag: Tag? = null
)

data class Tag(
    val colorResId: Int,
    val name: String
)
