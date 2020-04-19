package com.ccamacho.udemycoursejetpack.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StateModel {

    private val isEnabledLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val _isEnabledLiveData: LiveData<Boolean> = isEnabledLiveData

    private var isEnabled: Boolean = false
    private var state: String? = ""

    fun updateState(input: String?) {
        if (state.isNullOrEmpty() != input.isNullOrEmpty()) {
            isEnabled = !input.isNullOrEmpty()
            isEnabledLiveData.postValue(isEnabled)
        }
        state = input
    }
}