package com.example.egardia_mobile_development_assessment.ui.fragments.carslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.egardia_mobile_development_assessment.data.Repository
import com.example.egardia_mobile_development_assessment.data.model.Cars
import com.example.egardia_mobile_development_assessment.utils.Resource
import kotlinx.coroutines.Dispatchers

class CarListViewModel : ViewModel() {
    fun getAllCars() = liveData<Resource<Cars>>(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(Repository().getAllCars()))
        } catch (e:Exception){
            emit(Resource.error(null, e.message.toString()))
        }
    }
}