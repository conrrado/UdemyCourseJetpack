package com.ccamacho.udemycoursejetpack.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.foundations.BaseRecyclerAdapter
import com.ccamacho.udemycoursejetpack.models.Tasks
import com.ccamacho.udemycoursejetpack.views.TodoView
import kotlinx.android.synthetic.main.item_tasks.view.*

class TasksAdapter(
    taskList: MutableList<Tasks> = mutableListOf()
): BaseRecyclerAdapter<Tasks>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false))

    class ViewHolder(view: View): BaseViewHolder<Tasks>(view) {

        override fun onBind(data: Tasks) {
            view.title_view.text = data.title

            data.todos.forEach {todo ->
                val todoView = (LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.todo_container, false) as TodoView).apply {
                    initView(todo)
                }
                view.todo_container.addView(todoView)
            }
        }
    }
}