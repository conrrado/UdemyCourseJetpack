package com.ccamacho.udemycoursejetpack.tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.foundations.BaseRecyclerAdapter
import com.ccamacho.udemycoursejetpack.models.Tasks
import com.ccamacho.udemycoursejetpack.views.TaskView

class TasksAdapter(
    taskList: MutableList<Tasks> = mutableListOf()
): BaseRecyclerAdapter<Tasks>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tasks, parent, false))

    class ViewHolder(view: View): BaseViewHolder<Tasks>(view) {

        override fun onBind(data: Tasks) {
            (view as TaskView).initView(data)
        }
    }
}