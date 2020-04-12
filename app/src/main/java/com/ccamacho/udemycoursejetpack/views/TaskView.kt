package com.ccamacho.udemycoursejetpack.views

import android.content.Context
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

    fun initView(task: Tasks, todoCheckedCallback: (Int, Boolean) -> Unit) {
        this.task = task

        title_view.text = task.title
        task.todos.forEachIndexed() {todoIndex,  todo ->
            val todoView = (LayoutInflater.from(context).inflate(R.layout.view_todo, todo_container, false) as TodoView).apply {
                initView(todo) { isChecked ->

                    todoCheckedCallback.invoke(todoIndex, isChecked)

                    this@TaskView.title_view.removeStrikeThrough()
                    if (isTaskComplete()) {
                        this@TaskView.title_view.setStrikeThrough()
                    }
                }
            }
            todo_container.addView(todoView)
        }
    }

    private fun isTaskComplete(): Boolean = task.todos.filter { !it.isComplete }.isEmpty()
}