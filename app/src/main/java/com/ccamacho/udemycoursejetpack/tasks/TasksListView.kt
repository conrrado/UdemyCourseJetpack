package com.ccamacho.udemycoursejetpack.tasks

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ccamacho.udemycoursejetpack.models.Tasks
import kotlinx.android.synthetic.main.fragment_tasks_list.view.*

class TasksListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
): ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: TasksAdapter
    private lateinit var touchActionDelegate: TasksListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: TaskListViewContract

    fun initView(tasksDelegate: TasksListFragment.TouchActionDelegate, dataActionDelegate: TaskListViewContract) {
        setDelegate(tasksDelegate, dataActionDelegate)
        setUpView()
    }

    private fun setDelegate(tasksDelegate: TasksListFragment.TouchActionDelegate, dataActionDelegate: TaskListViewContract) {
        touchActionDelegate = tasksDelegate
        this.dataActionDelegate = dataActionDelegate
    }

    private fun setUpView() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        adapter = TasksAdapter(
            touchActionDelegate =  touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        recycler_view.adapter = adapter
    }

    fun updateList(list: MutableList<Tasks>) {
        adapter.updateList(list)
    }
}