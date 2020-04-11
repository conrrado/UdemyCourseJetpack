package com.ccamacho.udemycoursejetpack.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {

            text_view.text =
                when(this) {
                    NavigationActivity.FRAGMENT_VALUE_TASK -> "this is a task!"
                    NavigationActivity.FRAGMENT_VALUE_NOTE -> "this is a note!"
                    else -> "something went wrong!"
                }
        }
    }
}