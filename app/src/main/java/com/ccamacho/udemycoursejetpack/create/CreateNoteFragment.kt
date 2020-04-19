package com.ccamacho.udemycoursejetpack.create

import android.content.Context
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.foundations.ApplicationScope
import com.ccamacho.udemycoursejetpack.foundations.NullFieldChecker
import com.ccamacho.udemycoursejetpack.models.Note
import com.ccamacho.udemycoursejetpack.notes.INoteModel
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import toothpick.Toothpick
import java.lang.RuntimeException
import javax.inject.Inject

class CreateNoteFragment : Fragment(), NullFieldChecker {

    @Inject
    lateinit var model: INoteModel

    @Inject
    lateinit var stateModel: StateModel

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Toothpick.inject(this, ApplicationScope.scope)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        note_edit_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                stateModel.updateState(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun saveNote(callback: (Boolean) -> Unit) {
        GlobalScope.launch {
            createNote()?.let { note ->
                model.addNote(note) { success ->
                    callback.invoke(success)
                }
            } ?: callback.invoke(false)
        }
    }

    private fun createNote(): Note? =
        if (!hasNullField()) {
            Note(description = note_edit_text.editableText.toString())
        } else {
            null
        }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction()
    }

    override fun hasNullField(): Boolean = note_edit_text.editableText.isNullOrEmpty()

    companion object {
        @JvmStatic
        fun newInstance() = CreateNoteFragment()
    }
}
