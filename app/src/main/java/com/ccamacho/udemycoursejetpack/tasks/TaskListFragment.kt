package com.ccamacho.udemycoursejetpack.tasks

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ccamacho.udemycoursejetpack.R

class TaskListFragment : Fragment() {

    lateinit var viewModel: TaskViewModel
    lateinit var contentView: TaskListView
    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.let {
            if (it is TouchActionDelegate) {
                touchActionDelegate = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false).apply {
            contentView = this as TaskListView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewModel()
        setContentView()
    }

    private fun setContentView() {
        contentView.initView(touchActionDelegate, viewModel)
    }

    private fun bindViewModel() {
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        viewModel.taskListLiveData.observe(viewLifecycleOwner, Observer { tasksList ->
            contentView.updateList(tasksList)
        })
    }

    companion object {
        fun newInstance() = TaskListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }
}