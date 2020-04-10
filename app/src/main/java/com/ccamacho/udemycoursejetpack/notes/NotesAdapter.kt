package com.ccamacho.udemycoursejetpack.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.foundations.BaseRecyclerAdapter
import com.ccamacho.udemycoursejetpack.models.Notes
import com.ccamacho.udemycoursejetpack.views.NoteView
import kotlinx.android.synthetic.main.item_notes.view.*

class NotesAdapter(
    noteList: MutableList<Notes>
): BaseRecyclerAdapter<Notes>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false))

    class ViewHolder(view: View): BaseViewHolder<Notes>(view) {

        override fun onBind(data: Notes) {
            (view as NoteView).initView(data)
        }
    }
}