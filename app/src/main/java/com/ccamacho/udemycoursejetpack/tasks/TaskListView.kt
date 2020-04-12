package com.ccamacho.udemycoursejetpack.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ccamacho.udemycoursejetpack.models.Task
import kotlinx.android.synthetic.main.fragment_tasks_list.view.*

class TaskListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
): ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: TaskAdapter
    private lateinit var touchActionDelegate: TaskListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: TaskListViewContract

    fun initView(taskDelegate: TaskListFragment.TouchActionDelegate, dataActionDelegate: TaskListViewContract) {
        setDelegate(taskDelegate, dataActionDelegate)
        setUpView()
    }

    private fun setDelegate(taskDelegate: TaskListFragment.TouchActionDelegate, dataActionDelegate: TaskListViewContract) {
        touchActionDelegate = taskDelegate
        this.dataActionDelegate = dataActionDelegate
    }

    private fun setUpView() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        adapter = TaskAdapter(
            touchActionDelegate =  touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        recycler_view.adapter = adapter
    }

    fun updateList(list: MutableList<Task>) {
        adapter.updateList(list)
    }
}