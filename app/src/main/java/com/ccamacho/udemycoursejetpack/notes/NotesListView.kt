package com.ccamacho.udemycoursejetpack.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ccamacho.udemycoursejetpack.models.Notes
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NotesListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
): ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: NotesAdapter
    private lateinit var touchActionDelegate: NotesListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: NotesListViewContract

    fun initView(notesDelegate: NotesListFragment.TouchActionDelegate, dataActionDelegate: NotesListViewContract) {
        setDelegate(notesDelegate, dataActionDelegate)
        setUpView()
    }

    private fun setDelegate(notesDelegate: NotesListFragment.TouchActionDelegate, dataActionDelegate: NotesListViewContract) {
        touchActionDelegate = notesDelegate
        this.dataActionDelegate = dataActionDelegate
    }

    private fun setUpView() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        adapter = NotesAdapter(
            touchActionDelegate =  touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        recycler_view.adapter = adapter
    }

    fun updateList(list: MutableList<Notes>) {
        adapter.updateList(list)
    }
}