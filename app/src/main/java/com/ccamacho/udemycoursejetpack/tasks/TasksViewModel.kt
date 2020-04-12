package com.ccamacho.udemycoursejetpack.tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ccamacho.udemycoursejetpack.models.Tasks

class TasksViewModel: ViewModel(), TaskListViewContract {

    private val model: TasksModel = TasksModel()

    private val _tasksListLiveData: MutableLiveData<MutableList<Tasks>> = MutableLiveData()
    val tasksListLiveData: LiveData<MutableList<Tasks>> = _tasksListLiveData

    init {
        _tasksListLiveData.postValue(model.getFakeData())
    }



    override fun onTodoUpdated(taskIndex: Int, todoIndex: Int, isComplete: Boolean) {
        _tasksListLiveData.value?.get(taskIndex)?.todos?.get(todoIndex)?.isComplete = isComplete
    }
}