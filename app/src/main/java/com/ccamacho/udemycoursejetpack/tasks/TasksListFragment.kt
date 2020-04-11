package com.ccamacho.udemycoursejetpack.tasks

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.models.Tasks
import com.ccamacho.udemycoursejetpack.models.Todo
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class TasksListFragment : Fragment() {

    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        context?.let {

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
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = TasksAdapter(mutableListOf(
            Tasks("Treinamento de Android", mutableListOf(
                Todo("Fundamentos e básico", true),
                Todo("Android e Jetpack")
            )),
            Tasks("Leitura", mutableListOf(
                Todo("Harry Potter e a pedra filosofal"),
                Todo("Percy Jackson e o mar de monstros")
            ))
        ), touchActionDelegate)
        recycler_view.adapter = adapter
    }

    companion object {
        fun newInstance() = TasksListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }
}