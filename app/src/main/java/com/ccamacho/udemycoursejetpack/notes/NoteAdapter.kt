package com.ccamacho.udemycoursejetpack.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.foundations.BaseRecyclerAdapter
import com.ccamacho.udemycoursejetpack.models.Note
import com.ccamacho.udemycoursejetpack.navigation.NavigationActivity
import com.ccamacho.udemycoursejetpack.views.NoteView
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NoteListFragment.TouchActionDelegate,
    val dataActionDelegate: NoteListViewContract
): BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_INFO) {
            NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false))
        } else {
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
        }

    class NotesViewHolder(view: View): BaseViewHolder<Note>(view) {

        override fun onBind(data: Note, listIndex: Int) {
            (view as NoteView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View): BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit, listIndex: Int) {
            view.button_text.text = view.context.getString(R.string.add_button_note)

            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }
    }
}