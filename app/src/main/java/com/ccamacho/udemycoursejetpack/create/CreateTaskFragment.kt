package com.ccamacho.udemycoursejetpack.create

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.foundations.StateChangeTextWatcher
import com.ccamacho.udemycoursejetpack.views.CreateTodoView
import kotlinx.android.synthetic.main.fragment_create_task.*
import kotlinx.android.synthetic.main.view_create_task.view.*
import kotlinx.android.synthetic.main.view_create_todo.view.*

class CreateTaskFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        create_task_view.task_edit_text.addTextChangedListener(object : StateChangeTextWatcher() {
            override fun afterTextChanged(s: Editable?) {

                if (!s.isNullOrEmpty() && previousValue.isNullOrEmpty()) {
                    addTodoView()
                } else if (!previousValue.isNullOrEmpty() && s.isNullOrEmpty()) {
                    removeTodoView(container_view.getChildAt(container_view.childCount - 1))
                }

                super.afterTextChanged(s)
            }
        })
    }

    private fun addTodoView() {
        val view = LayoutInflater.from(context).inflate(R.layout.view_create_todo, container_view, false) as CreateTodoView

        view.todo_edit_text.addTextChangedListener(object : StateChangeTextWatcher() {
            override fun afterTextChanged(s: Editable?) {

                if (!s.isNullOrEmpty() && previousValue.isNullOrEmpty()) {
                    addTodoView()
                } else if (!previousValue.isNullOrEmpty() && s.isNullOrEmpty()) {
                    removeTodoView(view)
                }

                super.afterTextChanged(s)
            }
        })

        container_view.addView(view)
    }

    private fun removeTodoView(view: View) {
        container_view.removeView(view)
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CreateTaskFragment()
    }
}
