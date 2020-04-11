package com.ccamacho.udemycoursejetpack.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.models.Tasks
import kotlinx.android.synthetic.main.item_tasks.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Tasks

    fun initView(task: Tasks) {
        this.task = task

        title_view.text = task.title
        task.todos.forEach { todo ->
            val todoView = (LayoutInflater.from(context).inflate(R.layout.view_todo, todo_container, false) as TodoView).apply {
                initView(todo) {
                    removeStrikeThrough()
                    if (isTaskComplete()) {
                        createStrikeThrough()
                    }
                }
            }
            todo_container.addView(todoView)
        }
    }

    private fun isTaskComplete(): Boolean = task.todos.filter { !it.isComplete }.isEmpty()

    private fun createStrikeThrough() {
        title_view.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        title_view.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}