package com.ccamacho.udemycoursejetpack.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ccamacho.udemycoursejetpack.R
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {

    lateinit var viewModel: NotesViewModal
    lateinit var touchActionDelegate: TouchActionDelegate

    lateinit var adapter: NotesAdapter

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
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(context)
        adapter = NotesAdapter(
            touchActionDelegate =  touchActionDelegate
        )
        recycler_view.adapter = adapter

        bindViewModel()
    }

    private fun bindViewModel() {
        viewModel = ViewModelProvider(this).get(NotesViewModal::class.java)

        viewModel.notesListLiveData.observe(viewLifecycleOwner, Observer { notesList ->
            adapter.updateList(notesList)
        })
    }

    companion object {
        fun newInstance() = NotesListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }
}