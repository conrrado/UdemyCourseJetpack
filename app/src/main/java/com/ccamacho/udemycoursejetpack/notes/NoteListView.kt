package com.ccamacho.udemycoursejetpack.notes

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.ccamacho.udemycoursejetpack.models.Note
import kotlinx.android.synthetic.main.fragment_notes_list.view.*

class NoteListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
): ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var adapter: NoteAdapter
    private lateinit var touchActionDelegate: NoteListFragment.TouchActionDelegate
    private lateinit var dataActionDelegate: NoteListViewContract

    fun initView(noteDelegate: NoteListFragment.TouchActionDelegate, dataActionDelegate: NoteListViewContract) {
        setDelegate(noteDelegate, dataActionDelegate)
        setUpView()
    }

    private fun setDelegate(noteDelegate: NoteListFragment.TouchActionDelegate, dataActionDelegateValue: NoteListViewContract) {
        touchActionDelegate = noteDelegate
        dataActionDelegate = dataActionDelegateValue
    }

    private fun setUpView() {
        recycler_view.layoutManager = LinearLayoutManager(context)
        adapter = NoteAdapter(
            touchActionDelegate =  touchActionDelegate,
            dataActionDelegate = dataActionDelegate
        )
        recycler_view.adapter = adapter
    }

    fun updateList(list: MutableList<Note>) {
        adapter.updateList(list)
    }
}