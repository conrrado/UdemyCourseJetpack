package com.ccamacho.udemycoursejetpack.views

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.ccamacho.udemycoursejetpack.models.Note
import kotlinx.android.synthetic.main.item_notes.view.*

class NoteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(note: Note, deleteButtonClickedCallback: () -> Unit) {
        description_view.text = note.description
        image_button.setOnClickListener {
            deleteButtonClickedCallback.invoke()
        }
    }
}