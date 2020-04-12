package com.ccamacho.udemycoursejetpack.views

import android.content.Context
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
            description_view.setStrikeThrough()
        }
        setUpCheckStateListener(todo, callback)
    }

    private fun setUpCheckStateListener(todo: Todo, callback: ((Boolean) -> Unit)? = null) {
        complete_checkBox.setOnCheckedChangeListener { _, isChecked: Boolean ->
            todo.isComplete = isChecked
            callback?.invoke(isChecked)
            description_view.removeStrikeThrough()
            if (isChecked) {
                description_view.setStrikeThrough()
            }
        }
    }
}