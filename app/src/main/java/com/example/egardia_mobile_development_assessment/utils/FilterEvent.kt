package com.example.egardia_mobile_development_assessment.utils

import androidx.lifecycle.MutableLiveData

object FilterEvent {
    private var filterState:Boolean = false

    fun filterStateEvent(){
        this.filterState = !filterState
        stateLiveData.postValue(this.filterState)
    }

    val stateLiveData = MutableLiveData<Boolean>()


}
