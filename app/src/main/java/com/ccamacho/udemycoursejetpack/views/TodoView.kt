package com.ccamacho.udemycoursejetpack.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.ccamacho.udemycoursejetpack.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(todo: Todo, callback: ((Boolean) -> Unit)? = null) {
        description_view.text = todo.description
        complete_checkBox.isChecked = todo.isComplete
        if (todo.isComplete) {
            createStrikeThrough()
        }
        setUpCheckStateListener(todo, callback)
    }

    fun setUpCheckStateListener(todo: Todo, callback: ((Boolean) -> Unit)? = null) {
        complete_checkBox.setOnCheckedChangeListener { _, isChecked: Boolean ->
            todo.isComplete = isChecked
            callback?.invoke(isChecked)
            removeStrikeThrough()
            if (isChecked) {
                createStrikeThrough()
            }
        }
    }

    private fun createStrikeThrough() {
        description_view.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        description_view.apply {
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}