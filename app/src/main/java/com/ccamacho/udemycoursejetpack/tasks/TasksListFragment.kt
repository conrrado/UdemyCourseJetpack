package com.ccamacho.udemycoursejetpack.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.models.Tasks
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class TasksListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = TasksAdapter(mutableListOf(
            Tasks("Tarefa 1"),
            Tasks("Tarefa 2")
        ))
        recycler_view.adapter = adapter
    }

    companion object {
        fun newInstance() = TasksListFragment()
    }
}