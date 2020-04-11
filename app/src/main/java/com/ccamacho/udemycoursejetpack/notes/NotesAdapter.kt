package com.ccamacho.udemycoursejetpack.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.foundations.BaseRecyclerAdapter
import com.ccamacho.udemycoursejetpack.models.Notes
import com.ccamacho.udemycoursejetpack.navigation.NavigationActivity
import com.ccamacho.udemycoursejetpack.views.NoteView
import kotlinx.android.synthetic.main.view_add_button.view.*

class NotesAdapter(
    noteList: MutableList<Notes> = mutableListOf(),
    val touchActionDelegate: NotesListFragment.TouchActionDelegate
): BaseRecyclerAdapter<Notes>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_INFO) {
            NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false))
        } else {
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
        }

    class NotesViewHolder(view: View): BaseViewHolder<Notes>(view) {

        override fun onBind(data: Notes) {
            (view as NoteView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View): BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.button_text.text = view.context.getString(R.string.add_button_note)

            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }
    }
}