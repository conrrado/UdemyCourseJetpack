package com.ccamacho.udemycoursejetpack.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.models.Task
import kotlinx.android.synthetic.main.item_tasks.view.*

class TaskView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    lateinit var task: Task

    fun initView(task: Task, todoCheckedCallback: (Int, Boolean) -> Unit, deleteCallback: () -> Unit) {
        resetChildViews()
        this.task = task
        initTaskLine(deleteCallback)
        addChildViews(todoCheckedCallback)
    }

    private fun resetChildViews() {
        todo_container.removeAllViewsInLayout()
    }

    private fun initTaskLine(deleteCallback: () -> Unit) {
        title_view.text = task.title

        image_button.setOnClickListener {
            deleteCallback.invoke()
        }

        if (task.isComplete()) {
            this@TaskView.title_view.setStrikeThrough()
        } else {
            this@TaskView.title_view.removeStrikeThrough()
        }
    }

    private fun addChildViews(todoCheckedCallback: (Int, Boolean) -> Unit) {
        task.todos.forEachIndexed() {todoIndex,  todo ->
            val todoView = (LayoutInflater.from(context).inflate(R.layout.view_todo, todo_container, false) as TodoView).apply {
                initView(todo) { isChecked ->
                    todoCheckedCallback.invoke(todoIndex, isChecked)
                }
            }
            todo_container.addView(todoView)
        }
    }
}