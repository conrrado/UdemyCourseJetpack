package com.ccamacho.udemycoursejetpack.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.foundations.BaseRecyclerAdapter
import com.ccamacho.udemycoursejetpack.models.Tasks
import kotlinx.android.synthetic.main.item_tasks.view.*
import kotlinx.android.synthetic.main.view_todo.view.*

class TasksAdapter(
    taskList: MutableList<Tasks> = mutableListOf()
): BaseRecyclerAdapter<Tasks>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false))

    class ViewHolder(view: View): BaseViewHolder<Tasks>(view) {

        override fun onBind(data: Tasks) {
            view.title_view.text = data.title

            data.todos.forEach {todo ->
                val todoView = LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todo_container, false).apply {
                    description_view.text = todo.description
                    complete_checkBox.isChecked = todo.isComplete
                }
                view.todo_container.addView(todoView)
            }
        }
    }
}