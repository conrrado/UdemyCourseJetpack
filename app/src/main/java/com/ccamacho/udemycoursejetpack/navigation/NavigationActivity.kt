package com.ccamacho.udemycoursejetpack.navigation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ccamacho.udemycoursejetpack.R
import com.ccamacho.udemycoursejetpack.create.CreateActivity
import com.ccamacho.udemycoursejetpack.notes.NoteListFragment
import com.ccamacho.udemycoursejetpack.tasks.TaskListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity(), TaskListFragment.TouchActionDelegate, NoteListFragment.TouchActionDelegate {

    private val mOnNavigationSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId) {
            R.id.navigation_tasks -> {
                replaceFragment(TaskListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notes -> {
                replaceFragment(NoteListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        replaceFragment(TaskListFragment.newInstance())
        nav_view.setOnNavigationItemSelectedListener(mOnNavigationSelectedListener)
    }

    private fun goToCreateActivity(fragmentValue: String) {
        startActivity(Intent(this, CreateActivity::class.java).apply {
            putExtra(FRAGMENT_TYPE_KEY, fragmentValue)
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_holder, fragment).commit()
    }

    override fun onAddButtonClicked(value: String) {
        goToCreateActivity(value)
    }

    companion object {
        const val FRAGMENT_TYPE_KEY = "f_t_k"
        const val FRAGMENT_VALUE_NOTE = "f_v_n"
        const val FRAGMENT_VALUE_TASK = "f_v_t"
    }
}